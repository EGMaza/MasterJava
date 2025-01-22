package org.egmaza.ejemplo;

import org.egmaza.pooherencia.*;

public class EjemploHerenciaToString {
           public static void main(String[] args) {
        
        System.out.println("======= Creando la instancia de la clase Alumno =======");
        Alumno alumno = new Alumno("Andres","Guzmán",18,"ESIME");
        alumno.setNotaLenguaje(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematicas(6.9);
        alumno.setEmail("andres@correo.com");

        System.out.println("======= Creando la instancia de la clase Alumno Internacional =======");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter","Gosling","Australia");

        alumnoInt.setEdad(19);
        alumnoInt.setInstitucion("ESIME");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaLenguaje(6.2);
        alumnoInt.setNotaHistoria(5.6);
        alumnoInt.setNotaMatematicas(6.5);
        alumnoInt.setEmail("peterG@correo.com");

        System.out.println("======= Creando la instancia de la clase Profesor =======");
        Profesor profesor = new Profesor("Luci","Pérez","Matemáticas");
        profesor.setEdad(37);
        profesor.setEmail("profesor.luci@colegio.com");

        System.out.println("=======-=======");

        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);
    }

    public static void imprimir(Persona persona){
        System.out.println(persona);
        System.out.println("=======-=======");
    }
}
