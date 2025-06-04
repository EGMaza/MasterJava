package org.egmaza.hilos.ejemplos;

import org.egmaza.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Hilo1");
        hilo.start();

        Thread hilo2 = new NombreThread("Hilo2");
        hilo2.start();

        Thread hilo3 = new NombreThread("Hilo3");
        hilo3.start();
        //Thread.sleep(1);
        System.out.println(hilo.getState());
    }
}
