package org.egmaza.datetime.ejemplos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {

    public static void main(String[] args) {

        LocalTime ahora = LocalTime.now();
        System.out.println("Hora actual: " + ahora);
        System.out.println("Hora: " + ahora.getHour());
        System.out.println("Minutos: " + ahora.getMinute());
        System.out.println("Segundos: " + ahora.getSecond());

        LocalTime seisContreinta = LocalTime.of(6, 30, 53);
        System.out.println("SeisContreinta: " + seisContreinta);
        seisContreinta = LocalTime.parse("18:30:45");
        System.out.println("SeisContreinta: " + seisContreinta);
        LocalTime sieteContreinta = LocalTime.of(6, 30).plus(1, ChronoUnit.HOURS);
        System.out.println("SieteContreinta: " + sieteContreinta);

        boolean esAnterior = LocalTime.of(6,30).isBefore(LocalTime.parse("07:30:02"));
        System.out.println("EsAnterior: " + esAnterior);

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        String seisConTreintaFormateado = seisContreinta.format(dtf);
        System.out.println("Seis con treinta pm formateada: " + seisConTreintaFormateado);
        String ahoraFormateado = ahora.format(dtf);
        String ahoraFormateado2 = dtf.format(ahora);
        System.out.println("La hora actual formateada: " + ahoraFormateado);
        System.out.println("La hora actual formateada: " + ahoraFormateado2);
        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}