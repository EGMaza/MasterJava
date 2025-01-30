package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Felino extends Mamifero{

    protected float tamanioGarras;
    protected int velocidad;

    public Felino(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanioGarras,
            int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico);
        this.tamanioGarras = tamanioGarras;
        this.velocidad = velocidad;
    }

    public float getTamanioGarras() {
        return tamanioGarras;
    }
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public String comer() {
        return "El felino come";
    }

    @Override
    public String comunicarse() {
        return "El felino se comunica";
    }

    @Override
    public String correr() {
        return "El felino corre";
    }

    @Override
    public String dormir() {
        return "El felino duerme";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nTamaño de garras: ")
            .append(tamanioGarras)
            .append("\nVelocidad: ")
            .append(velocidad);

        return sb.toString();
    }
}