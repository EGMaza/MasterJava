package org.egmaza.poointerfaces.repositorio;

import java.util.List;

import org.egmaza.poointerfaces.modelo.Cliente;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}