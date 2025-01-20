package ProyectoOrdenCompra;

public class Producto{
    private String nombre;
    private String fabricante;
    private int precio;

    public Producto(String nombre, String fabricante, int precio) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public String getFabricante() {
        return fabricante;
    }
    public int getPrecio() {
        return precio;
    }
}
