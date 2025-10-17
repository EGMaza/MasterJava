package org.egmaza.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {

    public static void main(String[] args) {

        LocalDateTime fecha1 = LocalDateTime.now();
        //fecha1 = fecha1.withMonth(9);
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(3).plusMinutes(30).plusDays(1);
        Duration lapsus = Duration.between(fecha1, fecha2);
        System.out.println("Lapso de tiempo: " + lapsus);
        System.out.println("Lapso en segundos: " + lapsus.getSeconds());
        System.out.println("Lapso en días: " + lapsus.toDays());
        System.out.println("Lapso en horas: " + lapsus.toHours());
        System.out.println("Lapso en minutos: " + lapsus.toMinutes());
        System.out.println("Sumamos 5 horas = " +  lapsus.plusHours(5));
    }
}