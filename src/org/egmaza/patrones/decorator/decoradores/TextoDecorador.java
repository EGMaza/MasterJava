package org.egmaza.patrones.decorator.decoradores;

import org.egmaza.patrones.decorator.Formateable;

abstract public class TextoDecorador implements Formateable {

    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}