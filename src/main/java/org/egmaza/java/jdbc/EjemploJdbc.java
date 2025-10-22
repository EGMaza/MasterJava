package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Categoria;
import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.Repositorio;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("================ Listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("================ Obtener por ID =============");
            System.out.println(repositorio.porId(1l));

            System.out.println("================ Insertar nuevo producto =============");
            Producto producto = new Producto();
            producto.setNombre("Teclado Razer mecánico");
            producto.setPrecio(550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);

            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}