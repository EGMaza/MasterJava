package org.egmaza.java8.lambda.tarea1lambda;

import java.util.function.Function;

public class EjemploTareaEliminaEspacios {
    public static void main(String[] args) {
        Function<String,String> f1 = frase->frase.toUpperCase().replaceAll("[ ,.]","");
        System.out.println("Frase resultante: " + f1.apply("Hola, como estas?"));
    }
}
