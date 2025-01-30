package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Tigre extends Felino{
    private String especieTigre;

    public Tigre(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanioGarras,
            int velocidad, String especieTigre) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String comer() {
        return String.format("El tigre \"%s\" es carnívoro y come otros animales", this.especieTigre);
    }

    @Override
    public String dormir() {
        return String.format("El tigre \"%s\" suele dormir durante el día", this.especieTigre);
    }

    @Override
    public String correr() {
        return String.format("El tigre \"%s\" corre a grandes velocidades en su habitad: %s", this.especieTigre, habitad);
    }

    @Override
    public String comunicarse() {
        return String.format("El tigre \"%s\" se comunica a través de marcadores de olor, señales visuales y sonidos vocales", this.especieTigre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nEspecie del tigre: ")
            .append(especieTigre);
        return sb.toString();
    }    
}