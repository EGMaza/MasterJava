package org.egmaza.poointerfaces;

import java.util.List;

import org.egmaza.poointerfaces.modelo.Cliente;
import org.egmaza.poointerfaces.repositorio.ClienteListRepositorio;
import org.egmaza.poointerfaces.repositorio.CrudRepositorio;
import org.egmaza.poointerfaces.repositorio.Direccion;
import org.egmaza.poointerfaces.repositorio.OrdenableRepositorio;
import org.egmaza.poointerfaces.repositorio.PaginableRepositorio;

public class EjemploRepositorio {
    public static void main(String[] args) {
        CrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "González"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Andrés", "Gunzmán"));

        List<Cliente> clientes = repo.listar();

        clientes.forEach(c -> System.out.println(c));
        //También se considera válido: 
        //clientes.forEach(System.out::println);
        System.out.println("======= paginable =======");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1, 3);
        paginable.forEach(d -> System.out.println(d));

        System.out.println("======= ordenar =======");
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo)
        .listar("nombre", Direccion.ASC);

        clientesOrdenAsc.forEach(cl -> System.out.println(cl));

        System.out.println("======= editar =======");
        Cliente beaActualizar = new Cliente("Bea","Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);

        ((OrdenableRepositorio)repo)
        .listar("nombre", Direccion.ASC)
        .forEach(ord -> System.out.println(ord));

        System.out.println("======= eliminar =======");
        repo.eliminar(2);
        repo.listar().forEach(c -> System.out.println(c));
    }
}