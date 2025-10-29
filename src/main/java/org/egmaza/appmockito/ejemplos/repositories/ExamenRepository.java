package org.egmaza.appmockito.ejemplos.repositories;

import org.egmaza.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {

    List<Examen> findAll();

    Examen guardar(Examen examen);

}