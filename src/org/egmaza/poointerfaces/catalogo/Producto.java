package org.egmaza.poointerfaces.catalogo;

abstract public class Producto implements IProducto{
    protected int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public double getPrecioVenta() {
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nPrecio: ")
            .append(precio);
        return sb.toString();
    }
}