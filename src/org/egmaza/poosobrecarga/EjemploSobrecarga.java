package org.egmaza.poosobrecarga;

public class EjemploSobrecarga {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        System.out.println("Sumar 2 enteros: " + calc.sumar(10,5));
        System.out.println("Sumar 2 float: " + calc.sumar(10.0f, 5f));
        System.out.println("Sumar float-int: " + calc.sumar(10f, 5));
        System.out.println("Sumar int-float: " + calc.sumar(10, 5.0f));
        System.out.println("Sumar 2 double: " +  calc.sumar(10.0, 5.0));
        System.out.println("Sumar 2 String: " + calc.sumar("10", "5"));
        System.out.println("Sumar 3 enteros: " + calc.sumar(10, 5, 3));
        
        System.out.println("Sumar 2 long: " + calc.sumar(10L, 5L));
        System.out.println("Sumar int y char: " +  calc.sumar(10, '@'));
        System.out.println("Sumar float-int: " + calc.sumar(10f, '@'));
        System.out.println("Sumar x enteros: " + calc.sumar(2,3,4,5,6,7,8));
    }
}