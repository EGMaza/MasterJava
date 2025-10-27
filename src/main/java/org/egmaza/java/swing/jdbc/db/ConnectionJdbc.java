package org.egmaza.java.swing.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {

    private static String url = "jdbc:mysql://localhost:3306/java_swing_jdbc";
    private static String user = "root";
    private static String password = "123456";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
}