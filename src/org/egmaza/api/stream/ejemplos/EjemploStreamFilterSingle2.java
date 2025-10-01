package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {

    public static void main(String[] args) {

        Usuario usuario = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García")
                .map(nombre -> {
                    return new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]);
                })
                .filter(u -> u.getId().equals(2))
                .findFirst().orElseGet(() -> new Usuario("Jonh", "Doe"));

        System.out.println(usuario);
    }
}