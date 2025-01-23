package org.egmaza.almacenventapormayor;

public class Limpieza extends Producto{
    private String componentes;
    private String litros;

    public Limpieza(String nombre, double precio, String componentes, String litros) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }
}
