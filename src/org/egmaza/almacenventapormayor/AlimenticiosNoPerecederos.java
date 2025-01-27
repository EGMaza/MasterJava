package org.egmaza.almacenventapormayor;

public class AlimenticiosNoPerecederos extends Producto{
    @SuppressWarnings("unused")
    private int contenido;
    @SuppressWarnings("unused")
    private int calorias;

    public AlimenticiosNoPerecederos(String nombre, double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }
}
