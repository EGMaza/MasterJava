package org.egmaza.poointerfaces.repositorio;

import java.util.List;
import org.egmaza.poointerfaces.modelo.Cliente;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);
}