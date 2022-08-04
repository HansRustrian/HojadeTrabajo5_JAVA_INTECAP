package HojadeTrabajo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Archivo_HT5 {

    public void leerarchivo() {
        
        // ARRAYLIST PARA CONTENER LA INFORMACION DE ENTRADA DE LOS 3 ARCHIVOS
        ArrayList<Constructor> salida = new ArrayList<>();

        //DEFINIMOS LOS RECURSOS DE LOS 3 ARCHIVOS A LEER COMO INPUT
        File archivo1;
        FileReader leer1;
        BufferedReader almacenamiento1;
        File archivo2;
        FileReader leer2;
        BufferedReader almacenamiento2;
        File archivo3;
        FileReader leer3;
        BufferedReader almacenamiento3;

        // INDICAMOS LOS NOMBRES DE LOS 3 ARCHIVOS A LEER DE INPUT
        archivo1 = new File("listado.txt");
        archivo2 = new File("identificacion.txt");
        archivo3 = new File("generales.txt");

        //SE DEFINE LA ENTRADA DE LOS ARCHIVOS Y LAS VARIABLES PARA MANIPULAR LA ESCRITURA Y DESPLIEGUE
        try {
            leer1 = new FileReader(archivo1);
            almacenamiento1 = new BufferedReader(leer1);
            String linea1 = "";

            leer2 = new FileReader(archivo2);
            almacenamiento2 = new BufferedReader(leer2);
            String linea2 = "";

            leer3 = new FileReader(archivo3);
            almacenamiento3 = new BufferedReader(leer3);
            String linea3 = "";

            //EL ARCHIVO PRINICIPAL ES EL PRIMERO Y MIENTRAS ESE TENGA DATOS SE VAN A LEER LOS DEMAS
            //ARCHIVOS, EN CASO QUE EL SEGUNDO O TERCER SE QUEDE SIN INFORMACION SE GRABARA CON
            //ESPACIOS ESOS CAMPOS EN EL ARRAYLIST
            while ((linea1 = almacenamiento1.readLine()) != null) {
                linea2 = almacenamiento2.readLine();
                if (linea2 == null) {
                    linea2 = "               ";
                }
                linea3 = almacenamiento3.readLine();
                if (linea3 == null) {
                    linea3 = "                                                            ";
                }
                
                //LE DAMOS EL CONTENIDO DE LOS ARCHIVOS AL ARRAYLIST POR MEDIO DE CONSTRUCTOR PARA QUE
                //LO ALMACENE EN ESE ORDEN
                salida.add(new Constructor(linea1, linea2, linea3));

            }

            //DEFINIMOS NUEVO ARCHIVO DE SALIDA, SI NO EXISTE LO CREA Y SI EXISTE SOLO AÑADE LOS DATOS
            //A LA COLA DE LO PREVIAMENTE INGRESADO
            File archivo = new File("salida_completa.txt");
            FileWriter escribir;
            PrintWriter lineas;

            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                    escribir = new FileWriter(archivo, true);
                    lineas = new PrintWriter(escribir);
                    
                    //POR MEDIO DE FOR SE RECORRE EL ARRAYLIST DONDE SE ALMACENO LA INFORMACION DE 
                    //LOS 3 ARCHIVOS Y AHORA SE LE DA SALIDA A UN SOLO ARCHIVO Y SE DESPLIEGA EN 
                    //CONSOLA LO QUE SE ESTA ALMACENANDO
                    System.out.println("LA INFORMACION ALMACENADA EN EL ARCHIVO DE SALIDA ES : ");
                    System.out.println("");
                    for (Constructor display : salida) {
                        System.out.println(display.nombre + "|" + display.identificacion + "|" + display.generales);
                        
                        lineas.println(display.nombre + "|" + display.identificacion + "|" + display.generales);
                    }
                    
                    //CIERRE DE RECURSOS DE ARCHIVO DE SALIDA
                    lineas.close();
                    escribir.close();
                } catch (Exception e) {
                    System.out.println("ERROR EN EL IF DE CREACION DE ARCHIVO : " + e);
                }
            } else {
                try {
                    escribir = new FileWriter(archivo, true);
                    lineas = new PrintWriter(escribir);
                    System.out.println("LA INFORMACION ALMACENADA EN EL ARCHIVO DE SALIDA ES : ");
                    System.out.println("");
                    for (Constructor display : salida) {
                        System.out.println(display.nombre + "|" + display.identificacion + "|" + display.generales);
                        lineas.println(display.nombre + "|" + display.identificacion + "|" + display.generales);
                    }
                    lineas.close();
                    escribir.close();
                } catch (Exception e) {
                    System.out.println("ERROR EN EL ELSE DE CREACION DE ARCHIVO : " + e);
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR EN EL READ DE LOS 3 ARCHIVOS : " + e);
        }
    }

    public static void main(String[] args) {
        
        //CREAMOS EL OBJETO DONDE ESTA EL METODO QUE NECESITAMOS EJECUTAR
        Archivo_HT5 ht5 = new Archivo_HT5();
        
        //LLAMAMOS METODO PARA VER EL RESULTADO
        ht5.leerarchivo();

    }

}

