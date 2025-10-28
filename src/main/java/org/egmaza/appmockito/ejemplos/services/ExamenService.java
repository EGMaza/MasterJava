package org.egmaza.appmockito.ejemplos.services;

import org.egmaza.appmockito.ejemplos.models.Examen;

public interface ExamenService {

    Examen findExamenPorNombre(String nombre);
}