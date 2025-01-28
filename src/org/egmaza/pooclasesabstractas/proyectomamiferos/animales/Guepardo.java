package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Guepardo extends Felino{

    public Guepardo(String habitad, float altura, float largo, float peso, String nombreCientifico, float tamanioGarras,
            int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
    }

    @Override
    public String comer() {
        return String.format("El Guepardo es carnívoro y come otros animales de su hábitad: ", habitad);
    }

    @Override
    public String dormir() {
        return String.format("El Guepardo (%s) es de hábitos tanto diurnos como nocturnos",nombreCientifico);
    }

    @Override
    public String correr() {
        return String.format("El Guepardo es el ser terrestre más rápido, alcanzando velocidades de hasta %d km/h",velocidad);
    }

    @Override
    public String comunicarse() {
        return String.format("El Guepardo (%s) emite sonidos similares a los maullidos de los gatos comunes",nombreCientifico);
    }
}