package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Categoria;
import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.Repositorio;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

public class EjemploJdbc {
    public static void main(String[] args) {
        
        try (Connection conn = ConexionBaseDatos.getInstancia()){
            
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("\n============== Listar");
            repositorio.listar().forEach(System.out::println);
            System.out.println("\n============== Obtener por ID");
            System.out.println(repositorio.porId(1L));

            System.out.println("============== Insertar/Actualizar producto");
            Producto producto = new Producto();
            producto.setNombre("Teclado Corsair K95 mecánico");
            producto.setPrecio(700);

            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);


            //ATENCIÓN: Descomentar la siguiente línea SOLO para INSERT
            //producto.setFechaRegistro(new Date());
            //ATENCIÓN: Descomentar la siguiente línea SOLO para UPDATE:
            producto.setId(11L);

            if(repositorio.guardar(producto)){
                System.out.println("Operacion realizada con éxito");
            }
            else{
                System.out.println("No se pudo concretar la operación");
            }

            //Descomentar la siguiente línea para eliminar un producto con el id proporcionado como parámetro
            //repositorio.eliminar(10L);
            System.out.println("=======POST ACTUALIZACIÓN=======");
            repositorio.listar().forEach(System.out::println);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}