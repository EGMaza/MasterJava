package org.egmaza.patrones.decorator2;

import org.egmaza.patrones.decorator2.decoradores.ConChocolateDecorador;
import org.egmaza.patrones.decorator2.decoradores.ConCremaDecorador;
import org.egmaza.patrones.decorator2.decoradores.ConLecheDecorador;

public class EjemploDecoradorCafe {

    public static void main(String[] args) {

        Configurable cafe = new Cafe("Cafe Mocka", 7);
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(conCrema);
        ConChocolateDecorador conChocolate = new ConChocolateDecorador(conLeche);

        System.out.println("El precio del café mocka es: " + conChocolate.getPrecioBase());
        System.out.println("Los ingredientes: " + conChocolate.getIngredientes());

        Configurable capuccino = new Cafe("Cafe Capuccino", 4);
        conCrema = new ConCremaDecorador(capuccino);
        conLeche = new ConLecheDecorador(conCrema);

        System.out.println("El precio del café capuccino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes: " + conLeche.getIngredientes());

        Configurable espresso = new Cafe("Café espresso", 3);
        System.out.println("El precio del café espresso es: " + espresso.getPrecioBase());
        System.out.println("Los ingredientes: " + espresso.getIngredientes());

    }
}