package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Canino extends Mamifero{

    protected String color;
    protected float tamanioColmillos;

    public Canino(String habitad, float altura, float largo, float peso, String nombreCientifico, String color,
            float tamanioColmillos) {
        super(habitad, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanioColmillos = tamanioColmillos;
    }

    public String getColor() {
        return color;
    }
    public float getTamanioColmillos() {
        return tamanioColmillos;
    }

    @Override
    public String comer() {
        return "El canino come";
    }

    @Override
    public String dormir() {
        return "El canino duerme";
    }

    @Override
    public String correr() {
        return "El canino corre";
    }

    @Override
    public String comunicarse() {
        return "El canino se comunica";
    }
}