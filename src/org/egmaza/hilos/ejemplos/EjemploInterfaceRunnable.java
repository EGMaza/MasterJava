package org.egmaza.hilos.ejemplos;

import org.egmaza.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Isla Mujeres")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
        new Thread(new ViajeTarea("Veracruh")).start();

    }
}
