package org.egmaza.poointerfaces.imprenta.modelo;

public interface Imprimible {
    String TEXTO_DEFECTO = "Desechando un valor por defecto";

    String imprimir();

    default String desechable(){
        return TEXTO_DEFECTO;
    }
}