package org.egmaza.patrones.decorator.decoradores;

import org.egmaza.patrones.decorator.Formateable;

public class ReemplazarEspaciosDecorador extends TextoDecorador{

    public ReemplazarEspaciosDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_");
    }
}