package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Lobo extends Canino{


    private int numCamada;
    private String especieLobo;

    public Lobo(String habitad, float altura, float largo, float peso, String nombreCientifico, String color,
            float tamanioColmillos, int numCamada, String especieLobo) {
        super(habitad, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    public int getNumCamada() {
        return numCamada;
    }
    public String getEspecieLobo() {
        return especieLobo;
    }

    @Override
    public String comer() {
        return String.format("El lobo caza a sus presas con sus colmillos de hasta %f cm", tamanioColmillos);
    }

    @Override
    public String dormir() {
        return String.format("El lobo %s es de hábitos nocturnos, por lo que duerme de día", especieLobo);
        
    }

    @Override
    public String correr() {
        return String.format("El lobo %s corre en el hábitad: %s", color, habitad);
        
    }

    @Override
    public String comunicarse() {
        return String.format("El lobo se puede comunicar con aullidos para buscar pareja, con la que puede tener camadas de hasta %d integrantes",numCamada);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nNumero de camada: ")
            .append(numCamada)
            .append("\nEspecie: ")
            .append(especieLobo);
        return sb.toString();
    }
    
}
