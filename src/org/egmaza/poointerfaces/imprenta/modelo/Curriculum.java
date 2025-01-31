package org.egmaza.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja{

    private String persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculum(String contenido, String persona, String carrera) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculum addExperiencia(String exp){
        this.experiencias.add(exp);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ")
            .append(persona)
            .append("\nResumen: ")
            .append(contenido)
            .append("\nProfesion: ")
            .append(carrera)
            .append("\nExperiencias:\n");

        for(String expe:this.experiencias){
            sb.append("- ")
                .append(expe)
                .append("\n");
        }
        return sb.toString();
    }
}