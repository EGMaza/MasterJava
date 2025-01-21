package org.egmaza.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripción;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    public Factura(String descripción, Cliente cliente){
        this.descripción = descripción;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }
    public int getFolio() {
        return folio;
    }
    public void setFolio(int folio) {
        this.folio = folio;
    }
    public String getDescripción() {
        return descripción;
    }
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ItemFactura[] getItems() {
        return items;
    }
    
    public void addItemFactura(ItemFactura item){
        if(indiceItems<MAX_ITEMS){
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal(){
        float total = 0;

        for(int i=0;i<indiceItems;i++){
            total+=this.items[i].calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(folio)
            .append("\nCliente: ")
            .append(this.cliente.getNombre())
            .append("\t NIF: ")
            .append(cliente.getNif())
            .append("\nDescripcion: ")
            .append(this.descripción)
            .append("\n");
            
        SimpleDateFormat df = new SimpleDateFormat("dd ' de ' MMMM, yyyy");
        sb.append("\nFecha Emision: ")
            .append(df.format(this.fecha))
            .append("\n")
            .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for(int i=0;i<indiceItems;i++){
            sb.append(this.items[i].toString())
                .append("\n");
        }
        sb.append("\nGran total: ")
            .append(calcularTotal());
        
        return sb.toString();
    }
    @Override
    public String toString() {
        return generarDetalle();
    }
}