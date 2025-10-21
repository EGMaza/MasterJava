package org.egmaza.patrones.decorator2.decoradores;

import org.egmaza.patrones.decorator2.Configurable;

public class ConLecheDecorador extends CafeDecorador{

    public ConLecheDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 3.7f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", leche";
    }
}