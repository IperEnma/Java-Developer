package com.mycompany.messages;

import java.sql.*;
import java.util.*;
import static com.mycompany.messages.Conexion.*;

/**
 *
 * @author fsociety
 */
public class MessagesDao {

    private Connection connect = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Message message;

    public List<Message> select() throws ClassNotFoundException {
        List<Message> messages = new ArrayList<>();
        try {
            this.connect = getConnection();
            this.ps = this.connect.prepareStatement("SELECT * FROM messages");
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                int id = this.rs.getInt("id_message");
                String mss = this.rs.getString("message");
                String author = this.rs.getString("author");
                String date = this.rs.getString("_date");

                this.message = new Message(id, mss, author, date);
                messages.add(this.message);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.connect);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return messages;
    }

    public int insert(Message message) throws ClassNotFoundException {
        int status = 0;
        try {
            this.connect = getConnection();
            this.ps = this.connect.prepareStatement(
                    "INSERT INTO messages(message, author, _date) VALUES(?, ?, CURRENT_TIME())");
            this.ps.setString(1, message.getMessage());
            this.ps.setString(2, message.getAuthor());
            status = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.ps);
                close(this.connect);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return status;
    }

    public int update(Message message) throws ClassNotFoundException {
        int status = 0;
        try {
            this.connect = getConnection();
            this.ps = this.connect.prepareStatement(
                    "UPDATE messages SET message=?, author=? WHERE id_message=?");
            this.ps.setString(1, message.getMessage());
            this.ps.setString(2, message.getAuthor());
            this.ps.setInt(3, message.getId());
            status = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.ps);
                close(this.connect);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return status;
    }
    
        public int delete(Message message) throws ClassNotFoundException {
        int status = 0;
        try {
            this.connect = getConnection();
            this.ps = this.connect.prepareStatement(
                    "DELETE FROM messages WHERE id_message=?");
            this.ps.setInt(1, message.getId());
            status = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.ps);
                close(this.connect);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return status;
    }
}
