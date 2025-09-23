package org.egmaza.hilos.tareahilos;

public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        verificarTipo();
    }

    public void verificarTipo(){
        if (this.tipo == Tipo.NUMERO) {
            for(int i = 1; i < 10; i++) {
                System.out.println("Numero: " + i);
            }
        } else if (this.tipo == Tipo.LETRA) {
            char letra = 'A';
            int valorEntero = letra;
            for(int i = 1; i < 27; i++) {
                System.out.println("Letra: " + letra);
                valorEntero++;
                letra = (char) valorEntero;
            }
        }
    }
}