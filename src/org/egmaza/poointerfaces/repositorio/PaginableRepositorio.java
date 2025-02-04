package org.egmaza.poointerfaces.repositorio;

import java.util.List;

import org.egmaza.poointerfaces.modelo.Cliente;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}