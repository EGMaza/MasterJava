package org.egmaza.anotaciones.ejemplo;

import org.egmaza.anotaciones.ejemplo.models.Producto;
import org.egmaza.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto p = new  Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa dE ceNtro de roble");
        p.setPrecio(1000L);


        System.out.println("json = " + JsonSerializador.convertirJson(p));
    }
}