package org.egmaza.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime fechaTiempo = LocalDateTime.now();
        System.out.println("Fecha tiempo: " + fechaTiempo);

        fechaTiempo = LocalDateTime.of(2025, Month.DECEMBER,24,20,45,59);
        System.out.println("Fecha tiempo: " + fechaTiempo);

        fechaTiempo = LocalDateTime.parse("2025-12-25T21:45:59");
        System.out.println("Fecha tiempo: " + fechaTiempo);

        LocalDateTime fechaTiempo2 = fechaTiempo.plusDays(1).plusHours(3);
        System.out.println("Fecha tiempo: " + fechaTiempo);
        System.out.println("Fecha tiempo2: " + fechaTiempo2);
        System.out.println("Fecha tiempo3: " + fechaTiempo.minusHours(5));

        Month mes = fechaTiempo.getMonth();
        System.out.println("Mes: " + mes);
        int dia = fechaTiempo.getDayOfMonth();
        System.out.println("Dia: " + dia);
        int anio =  fechaTiempo.getYear();
        System.out.println("Año: " + anio);

        String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("Formato1: " + formato1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        String formato2 = fechaTiempo.format(dtf);
        System.out.println("Formato2: " + formato2);

        String formato3 = dtf.format(fechaTiempo);
        System.out.println("Formato3: " + formato3);
    }
}