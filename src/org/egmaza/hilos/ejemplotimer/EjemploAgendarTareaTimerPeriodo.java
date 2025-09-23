package org.egmaza.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomic = new AtomicInteger(3);

        Timer timer = new Timer();
        timer.schedule(new  TimerTask() {
            //private int contador = 3;

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                //int i = contadorAtomic.decrementAndGet();
                if(i>0){
                    toolkit.beep();
                    System.out.println("Tarea "+ (4-i) +" realizada en: " + new Date() + " nombre del thread: " +  Thread.currentThread().getName());
                    //contador--;
                }
                else{
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 0,10000);

        System.out.println("Agendamos una tarea inmediata que se repite cada 10 segundos");
    }
}
