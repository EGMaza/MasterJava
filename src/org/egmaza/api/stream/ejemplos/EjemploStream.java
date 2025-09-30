package org.egmaza.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {

    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe");
        //nombres.forEach(System.out::println);

        String[] arr = {"Patoso", "Paco", "Pepa", "Pepe"};
        Stream<String> nombres2 = Arrays.stream(arr);
        //nombres2.forEach(System.out::println);

        Stream<String> nombres3 = Stream.<String>builder().add("Patoas")
                .add("Paco")
                .add("Pepa")
                .add("Pepe")
                .build();

        //nombres3.forEach(System.out::println);

        List<String> lista = new ArrayList<>();
        lista.add("Patoseno");
        lista.add("Paco");
        lista.add("Pepa");
        lista.add("Pepe");

        //Stream<String> nombres4 = lista.stream();
        //nombres4.forEach(System.out::println);

        lista.stream().forEach(System.out::println);

    }
}
