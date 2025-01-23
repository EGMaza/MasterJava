package org.egmaza.almacenventapormayor;

public class Persona {
    private String nombre;
    private String direccion;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, String direccion) {
        this(nombre);
        this.direccion = direccion;
    }
}