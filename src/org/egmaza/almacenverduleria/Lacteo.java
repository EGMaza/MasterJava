package org.egmaza.almacenverduleria;

public class Lacteo extends Producto{
    private int cantidad;
    private int proteinas;

    public Lacteo(String nombre, double precio, int cantidad, int proteinas) {
        super(nombre, precio);
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    public int getCantidad() {
        return cantidad;
    }
    public int getProteinas() {
        return proteinas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
        .append("\nCantidad: ")
        .append(cantidad)
        .append("\nProteinas: ")
        .append(proteinas);

        return sb.toString();
    }
}