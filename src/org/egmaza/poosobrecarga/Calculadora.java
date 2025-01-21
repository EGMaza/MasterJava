package org.egmaza.poosobrecarga;

public class Calculadora {

    public int sumar(int... varargs){
        int total = 0;
        for(int i:varargs){
            total+=i;
        }

        return total;
    }

    public int sumar(int a, int b){
        return a + b;
    }

    public float sumar(float a, float b){
        return a + b;
    }

    public float sumar(int i, float j){
        return i + j;
    }

    public float sumar(float i, int... varargs){
        float suma = i;
        for(int k:varargs){
            suma+=k;
        }
        return suma;
    }

    public double sumar(double i, double j){

        return i + j;
    }

    public int sumar(String a, String b){
        int resultado;
        try {
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
            
        } catch (NumberFormatException e) {
            resultado =0;
        }
        return resultado;
    }

    public int sumar(int a, int b, int c){
        return a + b + c;
    }
}