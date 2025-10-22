package org.egmaza.archivos.ejemplos.servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {

    public void crearArchivo(String nombre){
        File archivo = new File(nombre);

        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))){
            buffer.append("\nHola que tal amigos")
                    .append("\n¿todo bien? yo acá escribiendo un archivo...")
                    .append("\nHasta luego Lucas! (con BufferedWritterYTryCatchNuevo)");

            //buffer.close();
            System.out.println("El archivo se ha creado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo2(String nombre){
        File archivo = new File(nombre);

        try (PrintWriter printer = new PrintWriter(new FileWriter(archivo, true))){
            printer.println("Hola que tal amigos");
            printer.println("¿todo bien? yo acá escribiendo un archivo...");
            printer.printf("Hasta luego %s! (con PrinterWritterYTryCatchNuevo)", "Lucas");

            //printer.close();
            System.out.println("El archivo se ha creado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            String linea;
            while ((linea = reader.readLine())!=null){
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try (Scanner s = new Scanner(archivo)){

            s.useDelimiter("\n");
            while (s.hasNext()){
                sb.append(s.next()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}