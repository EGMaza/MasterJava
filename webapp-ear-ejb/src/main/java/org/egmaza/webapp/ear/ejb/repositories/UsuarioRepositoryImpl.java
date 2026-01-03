package org.egmaza.webapp.ear.ejb.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.egmaza.webapp.ear.ejb.entities.Usuario;

import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository{

    @Inject
    private EntityManager em;
    @Override
    public List<Usuario> listar() {
        return em.createQuery("from Usuario", Usuario.class).getResultList();
    }
}
