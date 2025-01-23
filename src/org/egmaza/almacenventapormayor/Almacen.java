package org.egmaza.almacenventapormayor;

public class Almacen {
    private Vendedor vendedor1;
    private Vendedor vendedor2;
    private Producto[] catalogoProductos;

    public Almacen(Vendedor vendedor1, Vendedor vendedor2, Producto[] catalogProductos) {
        this.vendedor1 = vendedor1;
        this.vendedor2 = vendedor2;
        this.catalogoProductos = catalogProductos;
    }
}
