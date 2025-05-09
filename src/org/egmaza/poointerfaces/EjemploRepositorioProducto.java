package org.egmaza.poointerfaces;

import org.egmaza.poointerfaces.modelo.Producto;
import org.egmaza.poointerfaces.repositorio.Direccion;
import org.egmaza.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.egmaza.poointerfaces.repositorio.OrdenableRepositorio;
import org.egmaza.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.egmaza.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.egmaza.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.egmaza.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("mesa", 58.50));
            repo.crear(new Producto("silla", 18d));
            repo.crear(new Producto("lampara", 15.5));
            repo.crear(new Producto("notebook", 488.89));

            List<Producto> productos = repo.listar();

            productos.forEach(c -> System.out.println(c));
            //También se considera válido:
            //productos.forEach(System.out::println);
            System.out.println("======= paginable =======");
            List<Producto> paginable = repo.listar(1, 3);
            paginable.forEach(d -> System.out.println(d));

            System.out.println("======= ordenar =======");
            List<Producto> productosOrdenAsc = repo
                    .listar("nombre", Direccion.ASC);

            productosOrdenAsc.forEach(cl -> System.out.println(cl));

            System.out.println("======= editar =======");
            Producto lamparaActualizar = new Producto("lampara escritorio", 23d);
            lamparaActualizar.setId(3);
            repo.editar(lamparaActualizar);
            Producto lampara = repo.porId(3);
            System.out.println(lampara);
            System.out.println("=================================");

            repo.listar("precio", Direccion.ASC).forEach(ord -> System.out.println(ord));

            System.out.println("======= eliminar =======");
            repo.eliminar(2);
            repo.listar().forEach(c -> System.out.println(c));

            System.out.println("======= total =======");
            System.out.println("Total de registros: " + repo.total());
        } catch (LecturaAccesoDatoException lade) {
            System.out.println(lade.getMessage());
            lade.printStackTrace();
        } catch (AccesoDatoException ade) {
            System.out.println(ade.getMessage());
            ade.printStackTrace();

        }
    }
}