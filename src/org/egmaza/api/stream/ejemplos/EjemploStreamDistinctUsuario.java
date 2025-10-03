package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García", "Pato Guzmán", "Pato Guzmán")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();


        nombres.forEach(System.out::println);

    }
}