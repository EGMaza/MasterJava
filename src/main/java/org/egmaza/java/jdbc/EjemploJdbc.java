package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Categoria;
import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.Repositorio;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {

    public static void main(String[] args) throws SQLException {


        try(Connection conn = ConexionBaseDatos.getConnection()){

            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                System.out.println("=============== Insertar nueva categoría ===============");
                Categoria categoria = new Categoria();
                categoria.setNombre("Línea Blanca");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoría guardada con éxito: " + nuevaCategoria.getId());

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                System.out.println("================ Listar =============");
                repositorio.listar().forEach(System.out::println);

                System.out.println("================ Obtener por ID =============");
                System.out.println(repositorio.porId(1L));

                System.out.println("================ Insertar nuevo producto =============");
                Producto producto = new Producto();
                producto.setNombre("Refrigerador LG 12ft");
                producto.setPrecio(9800);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcde00004");

                producto.setCategoria(nuevaCategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con éxito: " + producto.getId());
                repositorio.listar().forEach(System.out::println);
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback();
            }
        }
    }
}