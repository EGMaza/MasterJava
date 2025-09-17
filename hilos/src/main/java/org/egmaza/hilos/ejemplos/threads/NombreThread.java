package org.egmaza.hilos.ejemplos.threads;

public class NombreThread extends Thread {

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el métodos Run del hilo " +  this.getName());
        for (int i=0; i<10; i++) {
            System.out.println(this.getName()+" "+i);
        }
        System.out.println("Finaliza el hilo");
    }
}
