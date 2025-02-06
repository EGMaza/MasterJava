package org.egmaza.java.jdbc;

import java.sql.Statement;

import org.egmaza.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploJdbc {
    public static void main(String[] args) {
        //String dato = "Samsung TV";
        
        try (Connection conn = ConexionBaseDatos.getInstance();
        Statement stmt = conn.createStatement();
        //ResultSet resultado = stmt.executeQuery("SELECT * FROM productos where nombre='" + dato + "'");){
        ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");) {
            
            while(resultado.next()){
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("precio"));
                System.out.print(" | ");
                System.out.print(resultado.getDate("fecha_registro"));
                System.out.println();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}