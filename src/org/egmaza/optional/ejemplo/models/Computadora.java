package org.egmaza.optional.ejemplo.models;

public class Computadora {

    private String nombre;
    private String modelo;

    public Computadora(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.modelo;
    }
}
