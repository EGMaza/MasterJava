package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.Repositorio;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbc {
    public static void main(String[] args) {
        
        try (Connection conn = ConexionBaseDatos.getInstance()){
            
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);
            System.out.println(repositorio.porId(1L));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}