package org.egmaza.java.jdbc.repositorio;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egmaza.java.jdbc.modelo.Producto;
import org.egmaza.java.jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException{
        return ConexionBaseDatos.getInstance();
    }


    @Override
    public List<Producto> listar(){
        List<Producto> productos = new ArrayList<>();
        
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos")){
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
        try(PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM productos WHERE id = ?")){
        //try(PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO productos Values('Estopa' , '25')")){    
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                prod = crearProducto(rs);
            }
            rs.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return prod;
    }

    @Override
    public void guardar(Producto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        return p;
    }
}