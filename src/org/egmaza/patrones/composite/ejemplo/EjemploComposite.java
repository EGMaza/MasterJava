package org.egmaza.patrones.composite.ejemplo;

import org.egmaza.patrones.composite.Archivo;
import org.egmaza.patrones.composite.Directorio;

public class EjemploComposite {

    public static void main(String[] args) {

        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");
        java.addComponente(new Archivo("patron-composite.docx"));

        Directorio streaam = new Directorio("Api Stream");
        streaam.addComponente(new Archivo("stream-map.docx"));

        java.addComponente(streaam);
        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx"));
        doc.addComponente(new Archivo("logo.jpeg"));

        System.out.println(doc.mostrar(0));
    }
}