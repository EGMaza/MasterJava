package org.egmaza.pooclasesabstractas.proyectomamiferos.animales;

public class Perro extends Canino{

    private int fuerzaMordida;

    public Perro(String habitad, float altura, float largo, float peso, String nombreCientifico, String color,
            float tamanioColmillos, int fuerzaMordida) {
        super(habitad, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    @Override
    public String comer() {
        return String.format("El perro doméstico no suele cazar para alimentarse, pero su fuerza de mordida alcanza hasta los %d kg/cm cuadrado de fuerza",fuerzaMordida);
    }

    @Override
    public String dormir() {
        return String.format("El perro duerme de noche en su hábitad: %s",habitad);
        
    }

    @Override
    public String correr() {
        return String.format("El perro, con un peso de %f, una altura de %f y un largo de %f puede correr ágilmente en su entorno", peso, altura, largo);
    }

    @Override
    public String comunicarse() {
        return String.format("El perro (%s) suele comunicarse ladrando", nombreCientifico);
    }
}