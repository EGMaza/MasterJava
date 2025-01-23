package org.egmaza.almacenverduleria;

public class NoPerecible extends Producto{
    private int contenido;
    private int calorias;
    
    public NoPerecible(String nombre, double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }
    public int getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
        .append("\nContenido: ")
        .append(contenido)
        .append("\nCalorias: ")
        .append(calorias);

        return sb.toString();
    }   
}