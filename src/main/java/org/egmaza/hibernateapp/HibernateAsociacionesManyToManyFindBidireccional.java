package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Alumno;
import org.egmaza.hibernateapp.entity.Curso;
import org.egmaza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesManyToManyFindBidireccional {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Alumno alumno1 = em.find(Alumno.class,1L);
            Alumno alumno2 = em.find(Alumno.class,2L);

            Curso curso1 = em.find(Curso.class,1L);//new Curso("Curso Java", "Andres");
            Curso curso2 = em.find(Curso.class,2L); //new Curso("Curso Hibernet", "Andres");

            alumno1.addCurso(curso1);
            alumno1.addCurso(curso2);

            alumno2.addCurso(curso1);

            em.getTransaction().commit();

            System.out.println("Alumno1= " + alumno1);
            System.out.println("Alumno2= " + alumno2);

            em.getTransaction().begin();

            //Curso c2 = em.find(Curso.class,3L);
            Curso c2 = new Curso("Curso Java EE 9", "Andres");
            c2.setId(2L);
            alumno1.removeCurso(c2);

            em.getTransaction().commit();
            System.out.println("Alumno1= " + alumno1);

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
