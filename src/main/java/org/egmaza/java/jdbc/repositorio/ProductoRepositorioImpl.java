package org.egmaza.java.jdbc.repositorio;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egmaza.java.jdbc.modelo.Categoria;
import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConexion() throws SQLException{
        return ConexionBaseDatos.getInstancia();
    }

    @Override
    public List<Producto> listar(){
        List<Producto> productos = new ArrayList<>();
        
        try(Statement stmt = getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pr.*, ct.nombre as categoria FROM productos " +
            " as pr inner join categorias as ct ON (pr.categoria_id = ct.id) ORDER BY pr.id")){
            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto prod = null;
        try(PreparedStatement stmt = getConexion().prepareStatement("SELECT pr.*, ct.nombre as categoria FROM " + 
                        "productos as pr inner join categorias as ct ON (pr.categoria_id = ct.id) WHERE pr.id = ?")){
            stmt.setLong(1, id);
            
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    prod = crearProducto(rs);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return prod;
    }

    @Override
    public boolean guardar(Producto producto) {
            
        String sql;
        boolean guardadoConExito = false;
        if(producto.getId() != null && producto.getId()>0){
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id=?";
        }
        else{
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)";
        }

        try(PreparedStatement stmt = getConexion().prepareStatement(sql)) {
            stmt.setString(1 , producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            if(producto.getId() != null && producto.getId()>0){
                stmt.setLong(4, producto.getId());
            }
            else{
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();
            guardadoConExito = true;
            return guardadoConExito;            
        } catch (SQLException e) {
            e.printStackTrace();
            return guardadoConExito;
        }
    }

    @Override
    public void eliminar(Long id) {
        
        try(PreparedStatement stmt = getConexion().prepareStatement("DELETE FROM productos WHERE id=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}