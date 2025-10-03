package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFlatMap {

    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Pato Guzmán",
                        "Paco González", "Pepa Gutierrez", "Pepe Mena",
                "Pepe García")
                .map(nombre -> {
                    return new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]);
                })
                .flatMap(u -> {
                    if(u.getNombre().equalsIgnoreCase("Pepe")){
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

        //List<Usuario> lista = nombres.collect(Collectors.toList());
        //lista.forEach(Usuario -> System.out.println(Usuario.getApellido()));
        //lista.forEach(System.out::println);
        // nombres.forEach(System.out::println);
        System.out.println(nombres.count());
    }
}