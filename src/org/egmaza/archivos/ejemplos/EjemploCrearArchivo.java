package org.egmaza.archivos.ejemplos;

import org.egmaza.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploCrearArchivo {

    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\egmaza\\Documents\\CursosUdemy\\MasterCompletoJava\\manejo_de_archivo\\archivos\\generados\\java.txt";
        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo2(nombreArchivo);
    }
}