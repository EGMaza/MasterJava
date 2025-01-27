package org.egmaza.almacenventapormayor;

public class Almacen {
    @SuppressWarnings("unused")
    private Vendedor vendedor1;
    @SuppressWarnings("unused")
    private Vendedor vendedor2;
    @SuppressWarnings("unused")
    private Producto[] catalogoProductos;

    public Almacen(Vendedor vendedor1, Vendedor vendedor2, Producto[] catalogProductos) {
        this.vendedor1 = vendedor1;
        this.vendedor2 = vendedor2;
        this.catalogoProductos = catalogProductos;
    }
}
