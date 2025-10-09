package org.egmaza.optional.ejemplo.models;

import java.util.Optional;

public class Computadora {

    private String nombre;
    private String modelo;
    private Procesador procesador;

    public Computadora(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public Computadora(String nombre, String modelo, Procesador procesador) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.procesador = procesador;
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

    public Optional<Procesador> getProcesador() {
        return Optional.ofNullable(procesador);
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.modelo;
    }
}
