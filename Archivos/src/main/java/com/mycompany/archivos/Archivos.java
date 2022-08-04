package com.mycompany.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivos {

    public void leerarchivo() {

        File archivo;  // VARIABLE DE TIPO FILE
        FileReader leer; // VARIABLE DE TIPO FILEREADER
        BufferedReader almacenamiento; // FUNCIONA PARA LEER EL DOCUMENTO

        //AQUI SE DA EL NOMBRE DEL ARCHIVO SI SE ENCUENTRA EL TXT EN LA MISMA CARPETA DEL PROYECTO
        //SOLO SE LE DA EL NOMBRE DEL ARCHIVO, PERO SI SE ENCUENTRA EN OTRA RUTA ENTONCES SE DEBE
        //DE DAR LA RUTA EXACTA DONDE ESTA EL ARCHIVO, SE DEBE SER PRECISO
        archivo = new File("ejemplo.txt");

        //EL TRY CATCH SE UTILIZA PARA MANEJO DE ERRORES 
        //SI LO QUE ESTA DENTRO DEL TRY FALLA ENTONCES SE EJECUTA LO QUE CONTENGA EL CATCH
        //EN EL CATCH SE IMPRIME EL VALOR DE E YA QUE CONTIENE INFORMACION DE LO QUE DIO ERROR
        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);

            String linea = "";

            while ((linea = almacenamiento.readLine()) != null) {
                
                //AQUI SE PROCESA CADA LINEA DEL ARCHIVO
                System.out.println(linea);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    public void creararchivo () {
        
        File archivo = new File("usuario.txt");
        FileWriter escribir; 
        PrintWriter lineas;
        
        String dato = "Hola Mundo";
        
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo,true);
                lineas = new PrintWriter(escribir);
                lineas.println(dato);
                lineas.println("Hola esto es una prueba");
                lineas.print("sin espacios");
                lineas.print("-prueba prueba");
                lineas.close();
                escribir.close();
            } catch (Exception e) {
                
            }
            
        } else {
            try {
                escribir = new FileWriter(archivo,true);
                lineas = new PrintWriter(escribir);
                lineas.println("Hola, este documento ya existe");
                lineas.print("sin espacios");
                lineas.print("-prueba prueba");
                lineas.close();
                escribir.close();
            } catch (Exception e) {
                
            }
        }
        
        
    }
    
    
    public static void main(String[] args) {

        Archivos a = new Archivos();
        a.leerarchivo();
        
    }

}
