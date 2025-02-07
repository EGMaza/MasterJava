package org.egmaza.java.jdbc;

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
            producto.setNombre("Teclado Razer mecánico");
            producto.setPrecio(500);
            //ATENCIÓN: Descomentar la siguiente línea SOLO para INSERT
            producto.setFechaRegistro(new Date());
            //Comentar o descomentar la siguiente línea hace que sea un insert o un uptade respectivamente:
            //producto.setId(7L);

            if(repositorio.guardar(producto)){
                System.out.println("Operacion realizada con éxito");
            }
            else{
                System.out.println("No se pudo concretar la operación");
            }

            //Descomentar la siguiente línea para eliminar un producto con el id proporcionado como parámetro
            //repositorio.eliminar(7L);
            System.out.println("=======POST ACTUALIZACIÓN=======");
            repositorio.listar().forEach(System.out::println);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}