package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Leon extends Felino{

    private int numManada;
    private float potenciaRugidoDecibel;

    

    public Leon(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanioGarras,
            int velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }
    public int getNumManada() {
        return numManada;
    }
    public float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }

    @Override
    public String comer() {
        return String.format("El león es carnívoro y caza a sus presas con garras de hasta %f cm de largo, en manadas de hasta %d integrantes",tamanioGarras, numManada);
    }
    @Override
    public String dormir() {
        return String.format("El león es de hábitos nocturnos y duerme durante el día en su hábitad: %s",habitad);
    }
    @Override
    public String correr() {
        return String.format("A pesar de pesar aproximadamente %f kg, el león corre a velocidades de hasta %d km/h, aunque por cortos periodos de tiempo", peso, velocidad);
    }
    @Override
    public String comunicarse() {
        return String.format("El león ruge alcanzando niveles de hasta %f decibeles ", potenciaRugidoDecibel);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nNúmero de manada: ")
            .append(numManada)
            .append("\nPotencia de rugido en decibeles: ")
            .append(potenciaRugidoDecibel);
        return sb.toString();
    }
}