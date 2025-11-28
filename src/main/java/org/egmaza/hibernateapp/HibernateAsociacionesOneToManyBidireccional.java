package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.entity.Factura;
import org.egmaza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccional {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();


        try{

            em.getTransaction().begin();

            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("paypal");

            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnología", 7000L);

            cliente.addFactura(f1).addFactura(f2);

            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println("Cliente= " + cliente);

            em.getTransaction().begin();
            //Factura f3 = new Factura("compras de supermercado", 5000L);
            //f3.setId(1L);
            Factura f3 = em.find(Factura.class, 1L);

            cliente.removeFacturas(f3);
            f3.setCliente(null);

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
