package org.egmaza.almacenventapormayor;

public class Vendedor extends Persona{
    @SuppressWarnings("unused")
    private double remuneracion;
    @SuppressWarnings("unused")
    private int noId;

    private static int vendedoresIds;

    public Vendedor(String nombre, String direccion, double remuneracion) {
        super(nombre, direccion);
        this.remuneracion = remuneracion;
        this.noId = ++vendedoresIds;
    }
}
