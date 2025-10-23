package org.egmaza.java.jdbc;

import org.egmaza.java.jdbc.modelo.Categoria;
import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.egmaza.java.jdbc.repositorio.Repositorio;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {

    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConexionBaseDatos.getInstance()){
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println("================ Listar =============");
                repositorio.listar().forEach(System.out::println);

                System.out.println("================ Obtener por ID =============");
                System.out.println(repositorio.porId(1L));

                System.out.println("================ Insertar nuevo producto =============");
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM mecánico");
                producto.setPrecio(1550);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                producto.setSku("abcde00003");
                repositorio.guardar(producto);

                System.out.println("Producto guardado con éxito");

                System.out.println("================ Editar producto =============");
                producto = new Producto();
                producto.setId(5L);
                producto.setNombre("Teclado Corsair k95 Metálico");
                producto.setPrecio(1050);
                producto.setSku("abcde00002");
                categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);
                System.out.println("Producto editado con éxito");
                repositorio.listar().forEach(System.out::println);
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                System.out.println("Falló la conexion");
            }


        }
    }
}