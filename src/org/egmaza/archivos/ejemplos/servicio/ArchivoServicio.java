package org.egmaza.archivos.ejemplos.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoServicio {

    public void crearArchivo(String nombre){
        File archivo = new File(nombre);

        try {
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.append("\nHola que tal amigos")
                    .append("\n¿todo bien? yo acá escribiendo un archivo...")
                    .append("\nHasta luego Lucas!");

            escritor.close();
            System.out.println("El archivo se ha creado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
