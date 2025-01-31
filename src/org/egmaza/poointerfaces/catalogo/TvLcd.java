package org.egmaza.poointerfaces.catalogo;

public class TvLcd extends Electronico{

    private int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() {
        return pulgada;
    }

    @Override
    public double getPrecioVenta() {
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nPulgadas: ")
            .append(pulgada);
        return sb.toString();
    }
}