package org.egmaza.personascompaniia;

public class Cliente extends Persona{
    private int clienteId;

    private static int iDClientes;

    public Cliente(String nombre, String apellido) {
        super(nombre, apellido);
        this.clienteId = ++iDClientes; 
    }

    public Cliente(String nombre, String apellido, String numeroFiscal) {
        super(nombre, apellido, numeroFiscal);
        this.clienteId = ++iDClientes; 
    }

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = ++iDClientes; 
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return super.toString() + "\nID de cliente: " + clienteId;
    }
}