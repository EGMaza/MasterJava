package ProyectoOrdenCompra;

public class EjemploOrdenes {
    public static void main(String[] args) {
        
        OrdenCompra orden1 = new OrdenCompra("Orden de pantallas");
        orden1.setCliente(new Cliente("Julian", "Jaramillo"));

        orden1.addProducto(new Producto("Pantalla LED Hisense 85 pulgadas","Hisense",15999));
        orden1.addProducto(new Producto("Smart Tv TCL 75 pulgadas","TCL",12999));
        orden1.addProducto(new Producto("Pantalla LED LG 75 pulgadas","LG",15499));
        orden1.addProducto(new Producto("Pantalla Television Redv 32 pulgadas","Redv",1999));

        System.out.println(orden1.detalleOrden());

        OrdenCompra orden2 = new OrdenCompra("Orden de equipos de sonido");
        orden2.setCliente(new Cliente("Alberto", "Hernandez"));

        orden2.addProducto(new Producto("Minicomponente LG 300w","LG",6999));
        orden2.addProducto(new Producto("Componente de audio HKPro Bluetooth","HKPro",14999));
        orden2.addProducto(new Producto("Minicomponente 2.1 4000w","Plus Power",2174));
        orden2.addProducto(new Producto("Sistema de audio Sony MCH-V43D","Sony",9999));

        System.out.println(orden2.detalleOrden());

        OrdenCompra orden3 = new OrdenCompra("Orden de computadoras");
        orden3.setCliente(new Cliente("Edgar", "Gómez"));

        orden3.addProducto(new Producto("Laptop Lenovo IdeaPad","Lenovo",11999));
        orden3.addProducto(new Producto("Laptop Huawei Matebook","Huawei",12999));
        orden3.addProducto(new Producto("Laptop Gamer HP NVIDIA GeForce","HP",15499));
        orden3.addProducto(new Producto("Laptop Dell NoteBook Inspiron","Dell",8499));

        System.out.println(orden3.detalleOrden());

    }
}
