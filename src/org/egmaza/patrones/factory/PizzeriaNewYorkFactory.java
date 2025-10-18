package org.egmaza.patrones.factory;

import org.egmaza.patrones.factory.producto.PizzaNewYorkItaliana;
import org.egmaza.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.egmaza.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{


    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPepperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
    }
}