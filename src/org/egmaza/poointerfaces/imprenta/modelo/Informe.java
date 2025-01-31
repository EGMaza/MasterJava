package org.egmaza.poointerfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible{
    private Persona autor;
    private Persona revisor;

    public Informe(String contenido, Persona autor, Persona revisor) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }
    
        @Override
    public String imprimir() {

        StringBuilder sb = new StringBuilder("Informe escrito por: ")
            .append(autor).append("\n")
            .append("Revisado por: ").append(revisor).append("\n")
            .append(contenido);
        return sb.toString();
    }
}