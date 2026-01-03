package org.egmaza.webapp.ear.ejb.repositories;

import org.egmaza.webapp.ear.ejb.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {

    List<Usuario> listar();
}
