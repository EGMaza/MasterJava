package org.egmaza.hilos.ejemplos;

import org.egmaza.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hola Mundillo");
        Thread hilo = new NombreThread("Jonh Doe");
        System.out.println(hilo.getState());
        hilo.start();
        Thread.sleep(8);
        System.out.println(hilo.getState());
    }
}
