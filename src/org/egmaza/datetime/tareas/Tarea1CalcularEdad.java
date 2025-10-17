package org.egmaza.datetime.tareas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Tarea1CalcularEdad {

    public static void main(String[] args) {

        String fechaNacString = "1991-07-01";
        LocalDate fechaNacLD = LocalDate.parse(fechaNacString);
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        Period edad = Period.between(fechaNacLD, fechaActual);

        System.out.println("La persona con fecha de nacimiento " + fechaNacLD.format(dtf) + " tiene actualmente " + edad.getYears() + " años");
        //La persona con fecha de nacimiento 01/julio/1991 tiene actualmente 34 años
    }
}