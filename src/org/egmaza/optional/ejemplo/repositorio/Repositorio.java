package org.egmaza.optional.ejemplo.repositorio;

import org.egmaza.optional.ejemplo.models.Computadora;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computadora> filtrar(String nombre);
}
