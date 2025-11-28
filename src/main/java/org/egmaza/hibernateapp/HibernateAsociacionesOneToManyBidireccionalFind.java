package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.entity.Factura;
import org.egmaza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccionalFind {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();


        try{

            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class,1L);
            cliente.setFormaPago("paypal");

            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnología", 7000L);

            cliente.addFactura(f1).addFactura(f2);

            //em.merge(cliente);
            em.getTransaction().commit();
            System.out.println("Cliente= " + cliente);

        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
