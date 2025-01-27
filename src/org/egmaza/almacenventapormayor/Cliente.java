package org.egmaza.almacenventapormayor;

public class Cliente extends Persona{
    @SuppressWarnings("unused")
    private int idCliente;

    private static int clientesIds;

    public Cliente(String nombre) {
        super(nombre);
        this.idCliente = ++clientesIds;
    }
}
