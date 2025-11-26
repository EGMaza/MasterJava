package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateQLanguaje {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("========== consultar todos ==========");
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta por id ==========");
        Cliente cliente = em.createQuery("select c from Cliente c where c.id =:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();

        System.out.println(cliente);

        System.out.println("===== consulta solo el nombre por el id =====");
        String nombreCliente = em.createQuery("select c.nombre from Cliente c where c.id =:id", String.class)
                .setParameter("id", 2L)
                .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("===== consulta por campos personalizados =====");
        Object[] objetoCliente = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id =:id", Object[].class)
                .setParameter("id", 2L)
                .getSingleResult();
        Long id = (Long)objetoCliente[0];
        String nombre = (String)objetoCliente[1];
        String apellido = (String)objetoCliente[2];
        System.out.println("id: " + id +", nombre: " + nombre + ", apellido: " + apellido);

        System.out.println("===== consulta por lista de campos personalizados =====");
        List<Object[]> registros = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c", Object[].class)
                .getResultList();

        for(Object[] reg: registros){
            id = (Long)reg[0];
            nombre = (String)reg[1];
            apellido = (String)reg[2];
            System.out.println("id: " + id +", nombre: " + nombre + ", apellido: " + apellido);
        }
        em.close();
    }
}
