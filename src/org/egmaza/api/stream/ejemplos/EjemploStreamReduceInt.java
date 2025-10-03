package org.egmaza.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceInt {

    public static void main(String[] args) {

        Stream<Integer> nombres = Stream.of(5, 10, 15, 20)
                .distinct();

        //int resultado = nombres.reduce(0, (a, b) -> a + b);
        //int resultado = nombres.reduce(0, (a, b)->Integer.sum(a, b));
        int resultado = nombres.reduce(0, Integer::sum);
        System.out.println(resultado);
    }
}