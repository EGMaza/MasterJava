package org.egmaza.almacenventapormayor;

public class Limpieza extends Producto{
    @SuppressWarnings("unused")
    private String componentes;
    @SuppressWarnings("unused")
    private String litros;

    public Limpieza(String nombre, double precio, String componentes, String litros) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }
}
