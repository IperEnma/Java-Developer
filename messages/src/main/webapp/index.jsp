<%-- 
    Document   : index
    Created on : Aug 2, 2022, 11:54:57 PM
    Author     : fsociety
--%>

<%@page import="com.mycompany.messages.Message"%>
<%@page import="com.mycompany.messages.MessagesDao"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container" style="margin-bottom: 16px">
            <div class="grid">
                <div class="g-col-6 g-col-md-4">&nbsp;</div>
                <div class="g-col-6 g-col-md-4">
                    <form action="index.jsp" method="GET">

                        <div class="mb-3">
                            <label class="form-label">Message</label>
                            <textarea class="form-control" name="message" rows="3"></textarea>
                            <div class="form-text">@IperEnma</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Author</label>
                            <input type="text" name="author" class="form-control">
                        </div>

                        <button type="submit" class="btn btn-primary" name="send">Send</button>
                    </form>
                </div>
                <div class="g-col-6 g-col-md-4">&nbsp;</div>
            </div>
            <%
                MessagesDao messageDao = new MessagesDao();
                if (request.getParameter("send") != null) {
                    Message message = new Message(
                            request.getParameter("message"),
                            request.getParameter("author")
                    );
                    messageDao.insert(message);
                }

            %>    
            <div class="grid text-center" style="--bs-rows: 3; --bs-columns: 3;margin-left:24%">
                <div class="g-start-2" style="grid-row: 2">
                    <%
                        //MessagesDao messageDao = new MessagesDao();
                        List<Message> messages = messageDao.select();
                        Collections.reverse(messages);

                        for (Message msm : messages) {

                    %>
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title"><%=msm.getAuthor()%></h5>
                            <h6 class="card-subtitle mb-2 text-muted"></h6>
                            <p class="card-text"><%=msm.getMessage()%></p>
                            <p class="blockquote-footer"><cite> <%=msm.getDate()%> </cite</p>
                            <a href="update.jsp?id=<%=msm.getId()%>
                               &&message=<%=msm.getMessage()%>
                               &&author=<%=msm.getAuthor()%>"
                               class="card-link">Edit</a>
                            <a href="delete.jsp?id=<%=msm.getId()%>" 
                               class="card-link">Delete</a>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>

        </div>        
    </body>
</html>
