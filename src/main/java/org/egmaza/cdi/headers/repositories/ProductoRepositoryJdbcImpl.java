package org.egmaza.apiservlet.webapp.headers.repositories;

import org.egmaza.apiservlet.webapp.headers.models.Categoria;
import org.egmaza.apiservlet.webapp.headers.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {

    private Connection conn;

    public ProductoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos2 as p " +
        "inner join categorias as c ON (p.categoria_id = c.id) order by p.id ASC")){

            while(rs.next()){
                productos.add(crearProducto(rs));
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;

        try(PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos2 as p " +
                "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")){
            stmt.setLong(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    producto = crearProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {

        String sql;
        if(producto.getId()!=null && producto.getId()>0){
            sql = "UPDATE productos2 set nombre=?, precio=?, sku=?, categoria_id=?, fecha_registro=? WHERE id=?";
        }
        else{
            sql = "INSERT INTO productos2 (nombre, precio, sku, categoria_id, fecha_registro) values (?, ?, ?, ?, ?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setString(3, producto.getSku());
            stmt.setLong(4, producto.getCategoria().getId());
            stmt.setDate(5, Date.valueOf(producto.getFechaRegistro()));

            if(producto.getId()!=null && producto.getId()>0){
                stmt.setLong(6,producto.getId());
            }
            else{
                //stmt.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM productos2 WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getLong("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setSku(rs.getString("sku"));
        producto.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        Categoria c = new Categoria();
        c.setId(rs.getLong("categoria_id"));
        c.setNombre(rs.getString("categoria"));
        producto.setCategoria(c);

        return producto;
    }
}