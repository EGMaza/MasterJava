package org.egmaza.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        Function<String, String> f1 = param -> "Hola que tal! " + param;
        String resultado = f1.apply("Andrés");
        System.out.println(resultado);

        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("José"));

        BiFunction<String,String,String> f3 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        System.out.println(f3.apply("josé", "peralta"));

        //BiFunction<String,String,Integer> f4 = (a, b) -> a.compareTo(b);
        BiFunction<String,String,Integer> f4 = String::compareTo;
        System.out.println(f4.apply("andres", "andres2"));

        BiFunction<String,String,String> f5 = String::concat;
        System.out.println(f5.apply("andres", "josé"));
    }

}
