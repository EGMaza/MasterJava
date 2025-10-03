package org.egmaza.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {

    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García", "Paco González", "Paco González", "Paco González", "Paco González")
                .distinct();

        String resultado = nombres.reduce("Resultado concatenación", (a, b) -> a + ", "+ b);
        System.out.println(resultado);
    }
}