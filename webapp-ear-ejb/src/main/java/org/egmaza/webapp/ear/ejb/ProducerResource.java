package org.egmaza.webapp.ear.ejb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class ProducerResource {

    @PersistenceUnit(name="ejemploJpa")
    private EntityManagerFactory emf;

    private EntityManager beanEntityManager(){
        return emf.createEntityManager()
    }

    public void close(@Disposes EntityManager entityManager){
        if (entityManager.isOpen()){
            entityManager.close();
            System.out.println("Cerrando la conexión del EntityManager!");
        }
    }
}