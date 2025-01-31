package org.egmaza.poointerfaces.imprenta;

import org.egmaza.poointerfaces.imprenta.modelo.*;
import static org.egmaza.poointerfaces.imprenta.modelo.Genero.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Resumen laboral...", new Persona("John", "Doe"), "Ingeniero en sistemas")
            .addExperiencia("Java")
            .addExperiencia("Oracle DBA")
            .addExperiencia("Spring Framework")
            .addExperiencia("Desarrollador fullstack")
            .addExperiencia("Angular");

        Libro libro = new Libro(new Persona("Erich", "Gamma"),
         "Patrones de diseño: Elem. Reusables POO", PROGRAMACION);
        libro.addPagina(new Pagina("Patrón Singleton"))
            .addPagina(new Pagina("Patrón Observador"))
            .addPagina(new Pagina("Patron Factory"))
            .addPagina(new Pagina("Patron Composite"))
            .addPagina(new Pagina("Patrón Facade"));

        Informe informe = new Informe("Estudio sobre microservicios", new Persona("Martín", "Fowler"), new Persona("James","Webb"));
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "un textos";
            }
        });
    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}