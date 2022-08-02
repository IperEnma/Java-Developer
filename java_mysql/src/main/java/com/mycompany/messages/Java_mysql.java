package com.mycompany.messages;

import java.sql.*;
/**
 *
 * @author fsociety
 */
public class Java_mysql {

    public static void main(String[] args) throws SQLException {
        continue;
    }
    static void InsertReg(String message, String author) throws SQLException {
        try (Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/messages_db?serverTimezone=UTC",
                "fsociety",
                "password"
        ); PreparedStatement insert = connect.prepareStatement(
                "INSERT INTO messages(message, author, fecha) VALUES (?, ?, CURRENT_TIME)")) {
            insert.setString(1, message);
            insert.setString(2, author);
            insert.executeUpdate();
        }
    }
    
    static void ShowReg() throws SQLException {
        try (Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/messages_db?serverTimezone=UTC",
                "fsociety",
                "password")) {
            System.out.println("success project");
            try (PreparedStatement select = connect.prepareStatement("SELECT * FROM messages"); 
                    ResultSet register = select.executeQuery()) {
                
                while(register.next()) {
                    int id = register.getInt("id_message");
                    String author = register.getString("author");
                    String message = register.getString("message");
                    String date = register.getString("fecha");
                    
                    System.out.println("id: " + id + "\nauthor: " + author +
                            "\nmessage: " + message + "\ndate: " + date + "\n");
                }
            }
        }
    }
    
    static void UpdateReg(String message, String author, int id) throws SQLException {
        Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/messages_db?serverTimeZone=UTC",
                "fsociety",
                "password"
        );
        PreparedStatement update = connect.prepareStatement(
                "UPDATE messages SET message=?, author=? WHERE id_message=?"
        );
        update.setString(1, message);
        update.setString(2, author);
        update.setInt(3, id);
        update.executeUpdate();
        update.close();
        connect.close();
    }
    
    static void DeleteReg(int id) throws SQLException {
        try (Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/messages_db?serverTimeZone=UTC",
                "fsociety",
                "password"
        )) {
            PreparedStatement delete = connect.prepareStatement(
                    "DELETE FROM messages WHERE id_message=?"
            );
            delete.setInt(1, id);
            delete.executeUpdate();
            delete.close();
        }
    }
}
