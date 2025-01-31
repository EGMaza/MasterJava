package org.egmaza.poointerfaces.catalogo;

abstract public class Electronico extends Producto implements IElectronico{
    
    protected String fabricante;

    public Electronico(int precio, String fabricante) {
        super(precio);
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nFabricante: ")
            .append(fabricante);
        return sb.toString();
    }
}