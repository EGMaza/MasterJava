package org.egmaza.ejemplo;

import org.egmaza.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Andres");
        alumno.setApellido("Guzmán");
        alumno.setInstitucion("ESIME");

        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Pérez");
        profesor.setAsignatura("Matemáticas");

        System.out.println(alumno.getNombre() + " " +
        alumno.getApellido() + " " + 
        alumno.getInstitucion());

        System.out.println("Profesor de " + profesor.getAsignatura() +": "+
        profesor.getNombre() + " " +
        profesor.getApellido());

    }
}
