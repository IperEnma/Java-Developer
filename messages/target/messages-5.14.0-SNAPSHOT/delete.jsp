<%-- 
    Document   : delete
    Created on : Aug 4, 2022, 12:42:52 AM
    Author     : fsociety
--%>

<%@page import="com.mycompany.messages.MessagesDao"%>
<%@page import="com.mycompany.messages.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            Message message = new Message(Integer.valueOf(id));
            MessagesDao messageDao = new MessagesDao();
            messageDao.delete(message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        %>
    </body>
</html>
