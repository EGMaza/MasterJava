package org.egmaza.hilos.tareahilos;

import java.util.concurrent.TimeUnit;

public class EjemploAlfanumericoTarea {
    public static void main(String[] args) throws InterruptedException {
        AlfanumericoTarea a = new AlfanumericoTarea(Tipo.LETRA);

        new Thread(a).start();

        TimeUnit.MILLISECONDS.sleep(500);

        new Thread(new AlfanumericoTarea(Tipo.NUMERO)).start();
    }
}