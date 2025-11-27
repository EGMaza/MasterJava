package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.dominio.ClienteDto;
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

        System.out.println("===== consulta por cliente y forma pago =====");
        registros = em.createQuery("select c, c.formaPago from Cliente c", Object[].class)
                        .getResultList();

        registros.forEach(reg ->{
            Cliente c = (Cliente)reg[0];
            String formaPago = (String)reg[1];
            System.out.println("formaPago = " + formaPago + ", el objeto completo: " + c);
        });

        System.out.println("===== consulta que puebla y devuelve un objeto entity de una clase personalizada =====");
        clientes = em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class)
                        .getResultList();

        clientes.forEach(System.out::println);

        System.out.println("===== consulta que puebla y devuelve otro objeto diferente de una clase personalizada =====");
        List<ClienteDto> clientesDto = em.createQuery("select new org.egmaza.hibernateapp.dominio.ClienteDto(c.nombre, c.apellido) from Cliente c", ClienteDto.class)
                .getResultList();

        clientesDto.forEach(System.out::println);

        System.out.println("===== consulta con nombre de clientes =====");
        List<String> nombres = em.createQuery("select c.nombre from Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("===== consulta con nombre únicos de clientes =====");
        nombres = em.createQuery("select distinct(c.nombre) from Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("===== consulta con formas de pago únicas =====");
        List<String> formasPago = em.createQuery("select distinct(c.formaPago) from Cliente c", String.class)
                        .getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("===== consulta con numero de formas de pago únicas =====");
        Long totalFormasPago = em.createQuery("select count(distinct(c.formaPago)) from Cliente c", Long.class)
                .getSingleResult();
        System.out.println("Total de formas de pago diferentes: " + totalFormasPago);

        System.out.println("===== consulta con nombre y apellido concatenados =====");
        //nombres = em.createQuery("select concat(c.nombre, ' ', c.apellido) as nombreCompleto from Cliente c", String.class)
        //                .getResultList();

        nombres = em.createQuery("select c.nombre || ' ' || c.apellido as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("===== consulta con nombre y apellido concatenados en mayuscula =====");
        nombres = em.createQuery("select upper(c.nombre || ' ' || c.apellido) as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("===== consulta con nombre y apellido concatenados en minuscula =====");
        nombres = em.createQuery("select lower(c.nombre || ' ' || c.apellido) as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("===== consulta para buscar por nombre =====");
        String param = "lu";
        param = param.toUpperCase();
        clientes = em.createQuery("select c from Cliente c where upper(c.nombre) like upper(:parametro)", Cliente.class)
                .setParameter("parametro", "%" + param + "%")
                .getResultList();
        clientes.forEach(System.out::println);


        em.close();
    }
}
