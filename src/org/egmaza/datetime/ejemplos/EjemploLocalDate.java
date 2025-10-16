package org.egmaza.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class EjemploLocalDate {

    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia: " + fechaActual.getDayOfMonth());
        System.out.println("Mes: " + fechaActual.getMonth());
        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Dia del año: "  + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());

        fechaActual = LocalDate.of(2025, 12, 25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2025, Month.NOVEMBER, 2);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2025-02-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diaDeManiana = LocalDate.now().plusDays(1);
        System.out.println("diaDeManiana = " + diaDeManiana);

        LocalDate mesAnteriorMismodia = LocalDate.now().minusMonths(1);
        System.out.println("mesAnteriorMismodia = " + mesAnteriorMismodia);

        LocalDate mesAnteriorMismodia2 = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("mesAnteriorMismodia2 = " + mesAnteriorMismodia2);

        DayOfWeek miercoles = LocalDate.parse("2025-11-12").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

        int once = LocalDate.of(2020, 11, 11).getDayOfMonth();
        System.out.println("once = " + once);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.now().isBefore(LocalDate.parse("2025-11-10"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.now().isAfter(LocalDate.parse("2025-11-10"));
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);
    }
}