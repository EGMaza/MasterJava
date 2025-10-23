package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Categoria;
import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.servicio.CatalogoServicio;
import org.egmaza.java.jdbc.servicio.Servicio;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {

    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("================ Listar =============");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        Producto producto = new Producto();
        producto.setNombre("Lampara Halógena de pared");
        producto.setPrecio(450);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcde00006");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con éxito: " + producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}