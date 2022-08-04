package com.mycompany.messages;

/**
 *
 * @author fsociety
 */

import java.sql.*;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost/messages_db?serverTimezone=UTC";
    private static final String USER = "fsociety";
    private static final String PASSWORD = "password";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("CONEXION SUCCESS YEAH");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
     public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Connection connect) throws SQLException {
        connect.close();
    }
}
