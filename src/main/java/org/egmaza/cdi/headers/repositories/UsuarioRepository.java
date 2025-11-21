package org.egmaza.cdi.headers.repositories;

import org.egmaza.cdi.headers.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {

    Usuario porUsername(String username) throws SQLException;

}
