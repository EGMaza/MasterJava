package org.egmaza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.egmaza.hibernateapp.entity.Cliente;
import org.egmaza.hibernateapp.services.ClienteService;
import org.egmaza.hibernateapp.services.ClienteServiceImpl;
import org.egmaza.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        ClienteService service = new ClienteServiceImpl(em);

        System.out.println("========== Listar ==========");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("========== Obtener por ID ==========");
        Optional<Cliente> optionalCliente = service.porId(4L);
        optionalCliente.ifPresent(System.out::println);

        System.out.println("========== Insertar nuevo cliente ==========");
        Cliente cliente = new Cliente();
        cliente.setNombre("Sofía");
        cliente.setApellido("Hernández");
        cliente.setFormaPago("paypal");

        service.guardar(cliente);
        System.out.println("Cliente guardado con éxito");
        service.listar().forEach(System.out::println);

        System.out.println("========== Editar cliente ==========");
        Long id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            c.setFormaPago("mercado pago");
            service.guardar(c);
            System.out.println("cliente editado con éxito");
            service.listar().forEach(System.out::println);
        });

        System.out.println("========== Eliminar cliente ==========");
        id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c ->{
           service.eliminar(c.getId());
            service.listar().forEach(System.out::println);
            System.out.println("cliente eliminado con éxito");
        });



        em.close();
    }
}
