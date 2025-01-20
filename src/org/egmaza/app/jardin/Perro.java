package org.egmaza.app.jardin;

import org.egmaza.app.hogar.*;

public class Perro {
    public String nombre;
    public String raza;

    String jugar(Persona persona){

        return persona.lanzarPelota();
    }
}
