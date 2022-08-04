package com.mycompany.messages;

/**
 *
 * @author fsociety
 */
public class Message {
    
    private int id; 
    private String message;
    private String author;
    private String date;

    public Message(int id) {
        this.id = id;
    }

    public Message(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public Message(int id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public Message(int id, String message, String author, String date) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setFecha(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Messages{");
        sb.append("id=").append(id);
        sb.append(", message=").append(message);
        sb.append(", author=").append(author);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
    
    
}
