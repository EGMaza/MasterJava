package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.entity.Direccion;
import org.egmaza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class,2L);
            cliente.setFormaPago("mercadopago");

            Direccion d1 = new Direccion("El vergel", 123);
            Direccion d2 = new Direccion("Vasco de gama", 456);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);

            em.merge(cliente);

            em.getTransaction().commit();
            System.out.println("Cliente= " + cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        finally {
            em.close();
        }
    }
}
