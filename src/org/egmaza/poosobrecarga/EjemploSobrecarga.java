package org.egmaza.poosobrecarga;

import static org.egmaza.poosobrecarga.Calculadora.sumar;

public class EjemploSobrecarga {
    public static void main(String[] args) {

        System.out.println("Sumar 2 enteros: " + sumar(10,5));
        System.out.println("Sumar 2 float: " + sumar(10.0f, 5f));
        System.out.println("Sumar float-int: " + sumar(10f, 5));
        System.out.println("Sumar int-float: " + sumar(10, 5.0f));
        System.out.println("Sumar 2 double: " +  sumar(10.0, 5.0));
        System.out.println("Sumar 2 String: " + sumar("10", "5"));
        System.out.println("Sumar 3 enteros: " + sumar(10, 5, 3));
        
        System.out.println("Sumar 2 long: " + sumar(10L, 5L));
        System.out.println("Sumar int y char: " +  sumar(10, '@'));
        System.out.println("Sumar float-int: " + sumar(10f, '@'));
        System.out.println("Sumar x enteros: " + sumar(2,3,4,5,6,7,8));
    }
}