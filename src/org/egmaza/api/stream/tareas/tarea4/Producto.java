package org.egmaza.api.stream.tareas.tarea4;

public class Producto {

    double precio;
    int cantidad;
    String descripcion;

    public Producto(double precio, int cantidad, String descripcion) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}