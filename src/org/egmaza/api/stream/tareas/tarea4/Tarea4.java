package org.egmaza.api.stream.tareas.tarea4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Tarea4 {
    public static void main(String[] args) {
        List<Producto> carrito = new ArrayList<Producto>();

        carrito.add(new Producto(7,8, "Manzanas"));
        carrito.add(new Producto(6,4, "Peras"));
        carrito.add(new Producto(12,5, "Aguacates"));
        carrito.add(new Producto(3,12, "Huevos"));
        carrito.add(new Producto(5,2, "Cebollas"));

        Function<List<Producto>, Double> sumador = p ->{
            return p.stream()
                    .map( u -> {
                        return (u.getCantidad() * u.getPrecio());
                    })
                    //.peek(System.out::println)
                    .reduce(0.0,(a,b)->a+b);
        };

        double total = sumador.apply(carrito);
        System.out.println("Total a pagar: "+total);
    }
}