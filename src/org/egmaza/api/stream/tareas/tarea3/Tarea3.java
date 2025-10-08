package org.egmaza.api.stream.tareas.tarea3;

import java.util.Arrays;
import java.util.stream.Stream;

public class Tarea3 {
    public static void main(String[] args) {

        String[][] bidimensional = {{"Raul", "Roberto"}, {"Juan"}, {"Jose", "Luis", "Alberto"}, {"Juan", "Eduardo"}
        , {"Salvador", "Luis", "Roberto"}, {"Antonio", "Juan"}, {"Arturo", "Manuel"}, {"Manuel", "Saúl"}, {"Antonio"}};

        String[] unidireccional = Arrays.stream(bidimensional)
                //.flatMap(Stream::of)
                .flatMap(x->{
                    return  Stream.of(x);
                })
                .distinct()
                //.toArray(String[]::new)
                .toArray( arreglo -> {
                    return new String[arreglo];
                });

        System.out.println(Arrays.toString(unidireccional)); //[Raul, Roberto, Juan, Jose, Luis, Alberto, Eduardo, Salvador, Antonio, Arturo, Manuel, Saúl]
    }
}