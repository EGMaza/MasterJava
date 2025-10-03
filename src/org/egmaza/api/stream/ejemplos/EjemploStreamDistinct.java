package org.egmaza.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamDistinct {

    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García", "Paco González", "Paco González", "Paco González", "Paco González")
                .distinct();

        nombres.forEach(System.out::println);
    }
}