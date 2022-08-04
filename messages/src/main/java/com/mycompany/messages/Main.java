package com.mycompany.messages;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fsociety
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Conexion.getConnection();
        MessagesDao messageDao = new MessagesDao();

        /*Message newmessage = new Message("Hello from main", "main");
        int status = messageDao.insert(newmessage);
        if (status == 1) {
            System.out.println("INSERT SUCESS FROM MAIN");
        } else {
            System.out.println("INSERT FAIL");
        } */
        
        /*Message newmessage = new Message(7, "HEY, UPDATE JW", "JW");
        int status = messageDao.update(newmessage);
        if (status == 1) {
            System.out.println("UPDATE SUCESS FROM MAIN");
        } else {
            System.out.println("UPDATE FAIL");
        }*/

        Message newmessage = new Message(6);
        int status = messageDao.delete(newmessage);
        if (status == 1) {
            System.out.println("DELETE SUCESS FROM MAIN");
        } else {
            System.out.println("DELETE FAIL");
        }

        List<Message> messages = messageDao.select();

        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
