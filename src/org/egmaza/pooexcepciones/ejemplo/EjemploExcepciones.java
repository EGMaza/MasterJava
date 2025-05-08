package org.egmaza.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args){

        Calculadora calc = new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese un entero como numerador: ");
        String denominador = JOptionPane.showInputDialog("Ingrese un entero como denominador: ");

        double division;

        try{
            division = calc.dividir(numerador,denominador);
            System.out.println("division2 = " + division);
        }
        catch (FormatoNumeroException fne) {
            System.out.println("Se detectó una excepción: ingrese un número válido" + fne.getMessage());
            fne.printStackTrace(System.out);
        }
        catch (DivisionPorCeroException dpce){
            System.out.println("Capturamos la excepción en tiempo de ejecución " + dpce.getMessage());
            main(args);
        }
        finally {
            System.out.println("Es opcional, pero se ejecuta siempre con o sin excepción");
        }

        System.out.println("Continuamos con el flujo de nuestra aplicción");
    }
}
