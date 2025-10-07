package org.egmaza.api.stream.tareas.tarea2;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Function;

public class Tarea2 {
    public static void main(String[] args) {

        int[] arreglo = {-4,-2,-322,-5,-6,-44,-322,-45,-778,-3};
        int[] arreglo2 = {};

        Function<int[], String> major = arr -> {
            OptionalInt p = Arrays.stream(arr).reduce((a, b)->(a>b ? a : b));
            return p.isEmpty() ? "El arreglo proporcionado como parámetro está vacío" : String.valueOf(p.getAsInt());
        };

        System.out.println(major.apply(arreglo)); //-2
        System.out.println(major.apply(arreglo2)); // El arreglo proporcionado como parámetro está vacío
    }
}