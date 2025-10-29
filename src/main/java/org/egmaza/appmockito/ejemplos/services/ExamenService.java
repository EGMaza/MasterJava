package org.egmaza.appmockito.ejemplos.services;

import org.egmaza.appmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> findExamenPorNombre(String nombre);

    Examen findExamenConNombreConPreguntas(String nombre);

    Examen guardar(Examen examen);
}