package org.egmaza.almacenventapormayor;

public class Persona {
    @SuppressWarnings("unused")
    private String nombre;
    @SuppressWarnings("unused")
    private String direccion;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, String direccion) {
        this(nombre);
        this.direccion = direccion;
    }
}