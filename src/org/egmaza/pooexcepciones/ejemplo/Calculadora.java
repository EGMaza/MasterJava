package org.egmaza.pooexcepciones.ejemplo;

public class Calculadora {

    public double dividir(int numerador, int divisor) throws DivisionPorCeroException {

        if (divisor==0){
            throw new DivisionPorCeroException("No se puede dividir por cero!");
        }
        return numerador/(double)divisor;
    }

    public double dividir(String numerador, String divisor) throws DivisionPorCeroException, FormatoNumeroException {

        int num;
        int div;
        try{
            num = Integer.parseInt(numerador);
            div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        }
        catch (NumberFormatException nfe){
            throw new FormatoNumeroException("Debe ingresar un número en el numerador y divisor");
        }

    }
}
