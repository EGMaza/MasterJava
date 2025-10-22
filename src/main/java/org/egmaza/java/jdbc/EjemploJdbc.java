package org.egmaza.java.jdbc;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Mexico_City";
        String username = "root";
        String password = "123456";
        final String stmt2 = "INSERT INTO productos (nombre, precio, fecha_registro) VALUES ('Coca Cola 600ml', 21, 2025-10-23)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")){

            while (resultado.next()){
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}