package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.Repositorio;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("================ Listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("================ Obtener por ID =============");
            System.out.println(repositorio.porId(1l));

            System.out.println("================ Editar producto =============");
            Producto producto = new Producto();
            producto.setId(3L);
            producto.setNombre("Teclado Razer Metálico");
            producto.setPrecio(700);
            repositorio.guardar(producto);
            System.out.println("Producto editado con éxito");
            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}