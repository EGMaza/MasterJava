package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.entity.Factura;
import org.egmaza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesManyToOne {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("credito");
            em.persist(cliente);

            Factura factura = new Factura("compras de oficina", 1000L);
            factura.setCliente(cliente);
            em.persist(factura);
            System.out.println("Factura: " + factura);
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        }
        finally{
            em.close();
        }
    }
}
