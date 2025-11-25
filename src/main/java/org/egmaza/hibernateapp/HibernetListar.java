package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernetListar {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("Select c from Cliente c ", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }

}
