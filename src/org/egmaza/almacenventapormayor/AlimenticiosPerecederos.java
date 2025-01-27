package org.egmaza.almacenventapormayor;

import java.util.Date;

public class AlimenticiosPerecederos extends Producto{
    @SuppressWarnings("unused")
    private String tipo;
    @SuppressWarnings("unused")
    private Date fechaCaducidad;
    
    public AlimenticiosPerecederos(String nombre, double precio, String tipo, Date fechaCaducidad) {
        super(nombre, precio);
        this.tipo = tipo;
        this.fechaCaducidad = fechaCaducidad;
    }
    
}
