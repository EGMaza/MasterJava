package org.egmaza.carrosupermercado;

public class EjemploGenericosCarroSupermercado {
    public static void main(String[] args) {
        BolsaSupermercado bolsaFrutas = new BolsaSupermercado();

        bolsaFrutas.addProducto(new Fruta("manzanas", 23.50, 1.0,"rojas"));
        bolsaFrutas.addProducto(new Fruta("naranjas", 18.00, 2.0, "naranjas"));
        bolsaFrutas.addProducto(new Fruta("peras", 28.90, 1.5, "amarillas"));
        bolsaFrutas.addProducto(new Fruta("uvas", 22.40, 1.2, "moradas"));

        imprimeProductos(bolsaFrutas);

        BolsaSupermercado bolsaLacteos = new BolsaSupermercado<>();
        bolsaLacteos.addProducto(new Lacteo("Yogurth", 24.00, 2, 2));
        bolsaLacteos.addProducto(new Lacteo("Petit suisse", 30.00, 3, 4));

        imprimeProductos(bolsaLacteos);

        BolsaSupermercado bolsaLimpieza = new BolsaSupermercado<>();
        bolsaLimpieza.addProducto(new Limpieza("maestro limpio", 28.00,"agente limpiador, fragancia", 2));
        bolsaLimpieza.addProducto(new Limpieza("pinol", 20, "aceite de pino, tensoactivos", 1));

        imprimeProductos(bolsaLimpieza);

        BolsaSupermercado bolsaNoPerecederos = new BolsaSupermercado();
        bolsaNoPerecederos.addProducto(new NoPerecedero("jamón",29.99,200,800));
        bolsaNoPerecederos.addProducto(new NoPerecedero("galletas marias", 32,1500, 2200));

        imprimeProductos(bolsaNoPerecederos);
    }

    public static <T> void imprimeProductos(BolsaSupermercado<T> bolsita){

        for(T a:bolsita.getProductos()){
            if(a instanceof Fruta){
                System.out.println("Fruta: " + ((Fruta)a).getNombre() +
                        ", Precio: " + ((Fruta)a).getPrecio() +
                        ", Peso: " + ((Fruta)a).getPeso() +
                        " kg, Color: " + ((Fruta)a).getColor());
            }
            else if (a instanceof Lacteo){
                System.out.println("Lacteo: " + ((Lacteo)a).getNombre() +
                        ", Precio: " + ((Lacteo)a).getPrecio() +
                        ", Cantidad: " + ((Lacteo)a).getCantidad() +
                        ", Proteinas: " + ((Lacteo)a).getProteinas());
            }
            else if (a instanceof Limpieza){
                System.out.println("Producto de limpieza: " + ((Limpieza)a).getNombre() +
                        ", Precio: " + ((Limpieza)a).getPrecio() +
                        ", Componentes: " + ((Limpieza)a).getComponentes() +
                        ", Litros: " + ((Limpieza)a).getLitros());
            }
            else if (a instanceof NoPerecedero){
                System.out.println("Producto no perecedero: " + ((NoPerecedero)a).getNombre() +
                        ", Precio: " + ((NoPerecedero)a).getPrecio() +
                        ", Contenido: " + ((NoPerecedero)a).getContenido() +
                        "g, Calorias: " + ((NoPerecedero)a).getCalorias());
            }
        }
    }
}
