package ProyectoOrdenCompra;

import java.util.Date;

public class OrdenCompra {
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos = new Producto[4];
    private int identificador = 0;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.fecha = new Date();
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
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

    public Producto[] getProductos() {
        return productos;
    }


    public void addProducto(Producto producto){
        if(identificador<4){
            productos[identificador] = producto;
            identificador++;
        }
        else{
            for(int i=0;i<productos.length-1;i++){
                productos[i] = productos[i+1];
            }
            productos[identificador-1] = producto;
        }

    }

    public String detalleOrden(){
        String detalleOrden="\n*****DETALLE ACTUAL DE LA ORDEN*****\n";
        if(cliente!=null){
            detalleOrden+="\nNombre del cliente: " + cliente.getNombre() + " " + cliente.getApellido();
        }
        detalleOrden+="\nDescripción de la orden: " + descripcion +"\nFecha de la orden: " + fecha;
        
        if(productos[0]!=null){
            detalleOrden+="\n\n****LISTADO DE PRODUCTOS****";
            for(Producto prod:productos){
                if(prod!=null){
                    detalleOrden+= "\n\nProducto: " + prod.getNombre() +"\nFabricante: " + prod.getFabricante() +
                    "\nPrecio unitario: $" + prod.getPrecio() + ".00";
                }
            }
            detalleOrden+="\n\nPrecio total de los productos: $" + granTotal() + ".00";
        }
        detalleOrden+="\n";

        return detalleOrden;
    }

    public int granTotal(){
        int total = 0;

        for(int i=0;i<productos.length;i++){
            if(productos[i]!=null){
                total+=productos[i].getPrecio();
            }
        }

        return total;
    }
}
