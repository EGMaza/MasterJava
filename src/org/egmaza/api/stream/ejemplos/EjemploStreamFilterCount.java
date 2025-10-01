package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {

    public static void main(String[] args) {

        long count = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García")
                .map(nombre -> {
                    return new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]);
                })
                .peek(System.out::println)
                .count();

        System.out.println(count);
    }
}