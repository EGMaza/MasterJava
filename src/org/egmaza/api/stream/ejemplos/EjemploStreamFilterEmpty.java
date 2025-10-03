package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {

    public static void main(String[] args) {

        Long count = Stream.of("Pato Guzmán",
                        "Paco González", "", "Pepe Mena",
                "")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();
        System.out.println("count = " + count);
    }
}