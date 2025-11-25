package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido: ", c.getApellido());
            String formaPago = JOptionPane.showInputDialog("Ingrese la forma de pago: ", c.getFormaPago());
            em.getTransaction().begin();

            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(formaPago);
            em.merge(c);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, c);
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
