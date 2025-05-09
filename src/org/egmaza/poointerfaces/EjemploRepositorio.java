package org.egmaza.poointerfaces;

import java.util.List;

import org.egmaza.poointerfaces.modelo.Cliente;
import org.egmaza.poointerfaces.repositorio.*;
import org.egmaza.poointerfaces.repositorio.excepciones.*;
import org.egmaza.poointerfaces.repositorio.lista.ClienteListRepositorio;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Perez"));
            repo.crear(new Cliente("Bea", "González"));
            repo.crear(new Cliente("Luci", "Martinez"));
            repo.crear(new Cliente("Andrés", "Guzmán"));
            //repo.crear(null);
            Cliente andres = new Cliente("Andrés", "Guzmán");
            repo.crear(andres);
            repo.crear(andres);

            List<Cliente> clientes = repo.listar();

            clientes.forEach(c -> System.out.println(c));
            //También se considera válido:
            //clientes.forEach(System.out::println);
            System.out.println("======= paginable =======");
            List<Cliente> paginable = repo.listar(1, 3);
            paginable.forEach(d -> System.out.println(d));

            System.out.println("======= ordenar =======");
            List<Cliente> clientesOrdenAsc = repo
                    .listar("nombre", Direccion.ASC);

            clientesOrdenAsc.forEach(cl -> System.out.println(cl));

            System.out.println("======= editar =======");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            Cliente bea = repo.porId(2);
            System.out.println(bea);
            System.out.println("=================================");

            ((OrdenableRepositorio) repo)
                    .listar("apellido", Direccion.ASC)
                    .forEach(ord -> System.out.println(ord));

            System.out.println("======= eliminar =======");
            repo.eliminar(2);
            repo.listar().forEach(c -> System.out.println(c));

            System.out.println("======= total =======");
            System.out.println("Total de registros: " + repo.total());
        }
        catch (RegistroDuplicadoAccesoDatoException rdad){
            System.out.println("Registro Duplicado: " + rdad.getMessage());
            rdad.printStackTrace();
        }
        catch (LecturaAccesoDatoException lade) {
            System.out.println("Lectura: " + lade.getMessage());
            lade.printStackTrace();
        }
        catch (EscrituraAccesoDatoException eade){
            System.out.println("Escritura: " + eade.getMessage());
            eade.printStackTrace();

        }
        catch (AccesoDatoException ade) {
            System.out.println("Generica: " + ade.getMessage());
            ade.printStackTrace();

        }
    }
}