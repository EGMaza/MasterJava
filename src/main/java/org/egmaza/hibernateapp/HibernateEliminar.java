package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEliminar {

    public static void main(String[] args) {

        Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar"));

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Cliente c = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
        catch (Exception e){

            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }
}
