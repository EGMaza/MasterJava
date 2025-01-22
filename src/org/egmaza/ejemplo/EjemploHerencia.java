package org.egmaza.ejemplo;

import org.egmaza.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {
        
        System.out.println("======= Creando la instancia de la clase Alumno =======");
        Alumno alumno = new Alumno();
        alumno.setNombre("Andres");
        alumno.setApellido("Guzmán");
        alumno.setInstitucion("ESIME");
        alumno.setNotaLenguaje(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematicas(6.9);

        System.out.println("======= Creando la instancia de la clase Alumno Internacional =======");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();

        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Gosling");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(19);
        alumnoInt.setInstitucion("ESIME");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaLenguaje(6.2);
        alumnoInt.setNotaHistoria(5.6);
        alumnoInt.setNotaMatematicas(6.5);

        System.out.println("======= Creando la instancia de la clase Profesor =======");
        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Pérez");
        profesor.setAsignatura("Matemáticas");

        System.out.println("=======-=======");
        System.out.println(alumno.getNombre() + " " +
        alumno.getApellido() + " " + 
        alumno.getInstitucion());

        System.out.println(alumnoInt.getNombre() + " " +
        alumnoInt.getApellido() + " " + 
        alumnoInt.getInstitucion() + " " +
        alumnoInt.getPais());

        System.out.println("Profesor de " + profesor.getAsignatura() +": "+
        profesor.getNombre() + " " +
        profesor.getApellido());

        @SuppressWarnings("rawtypes")
        Class clase = alumnoInt.getClass();
        while(clase.getSuperclass()!=null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();
        }
    }
}
