package org.egmaza.poosobrecarga;

public class Calculadora {

    private Calculadora(){
    }

    public static int sumar(int... varargs){
        int total = 0;
        for(int i:varargs){
            total+=i;
        }

        return total;
    }

    public static int sumar(int a, int b){
        return a + b;
    }

    public static float sumar(float a, float b){
        return a + b;
    }

    public static float sumar(int i, float j){
        return i + j;
    }

    public static float sumar(float i, int... varargs){
        float suma = i;
        for(int k:varargs){
            suma+=k;
        }
        return suma;
    }

    public static double sumar(double i, double j){

        return i + j;
    }

    public static int sumar(String a, String b){
        int resultado;
        try {
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
            
        } catch (NumberFormatException e) {
            resultado =0;
        }
        return resultado;
    }

    public static int sumar(int a, int b, int c){
        return a + b + c;
    }
}