package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        //Query query = em.createQuery("select c from Cliente c where c.id = ?1", Cliente.class);
        System.out.println("Ingrese el id");
        Long id = sc.nextLong();
        Cliente cliente = em.find(Cliente.class, id);
        //query.setParameter(1, id);
        //Cliente c = (Cliente)query.getSingleResult();
        System.out.println(cliente);
        em.close();
    }
}
