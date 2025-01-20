package org.egmaza.app.jardin;

import org.egmaza.app.hogar.*;
import static org.egmaza.app.hogar.Persona.*;
import static org.egmaza.app.hogar.ColorPelo.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Andrés");
        p.setApellido("Guzmán");
        p.setColorPelo(CAFE);
        System.out.println("Persona: " + p.getNombre());
        
        Perro perro = new Perro();
        perro.nombre = "tobby";
        perro.raza = "Bulldog";

        String jugando = perro.jugar(p);
        System.out.println("Jugando: " + jugando);

        String saludo = saludar();
        System.out.println("saludo = " + saludo);

        String generoMujer = GENERO_FEMENINO;
        String generoHombre = GENERO_MASCULINO;

        System.out.println("generoMujer = " + generoMujer);
        System.out.println("generoHombre = " + generoHombre);   
    }
}
