package org.egmaza.java8.lambda.tarea2lambda;

import java.util.Map;

@FunctionalInterface
public interface CuentaRepeticiones {

    public Map<String, Integer> cuentaRepeticiones(String frase);

}