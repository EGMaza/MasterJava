package org.egmaza.java8.lambda.tarea2lambda;

import java.util.HashMap;
import java.util.Map;

public class EjemploTareaCuentaRepeticiones {

    public static void main(String[] args) {

        CuentaRepeticiones cont = frase ->{

            String [] separadas = frase.split(" ");
            String palabraAnalizada, masRepetida = "";
            int max = 0, cuenta = 0;
            for (String s : separadas) {
                palabraAnalizada = s;
                for (String separada : separadas) {
                    if (palabraAnalizada.equals(separada))
                        cuenta++;
                }
                if (cuenta > max) {
                    max = cuenta;
                    masRepetida = palabraAnalizada;
                }
                cuenta = 0;
            }
            Map<String, Integer> resultado = new HashMap();
            resultado.put(masRepetida, max);
            return resultado;
            //return masRepetida;
        };

        String fraseAProbar = "a a a x a bb x b a x s x x s x v t a x c a x r s a xc ac x av d a x v s";
        Map<String, Integer> resultado = cont.cuentaRepeticiones(fraseAProbar);

        resultado.forEach((key, value) -> {
            System.out.println("La palabra más repetida fue \"" + key + "\", apareciendo " + value + " veces en la frase");
        });
    }
}