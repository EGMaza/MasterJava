package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García")
                .map(nombre -> {
                    return new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]);
                })
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);
        Optional<Usuario> usu = nombres.findFirst();

        System.out.println(usu.get());
    }
}