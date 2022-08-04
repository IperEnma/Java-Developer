<%-- 
    Document   : update
    Created on : Aug 4, 2022, 12:10:45 AM
    Author     : fsociety
--%>

<%@page import="com.mycompany.messages.Message"%>
<%@page import="com.mycompany.messages.MessagesDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="margin-bottom: 16px">
            <div class="grid">
                <div class="g-col-6 g-col-md-4">&nbsp;</div>
                <div class="g-col-6 g-col-md-4">
                    <form action="update.jsp" method="GET">

                        <div class="mb-3">
                            <input type="hidden" name="id" value="<%=request.getParameter("id")%>"
                                   <label class="form-label">Message</label>
                            <textarea class="form-control" name="message" rows="3"><%=request.getParameter("message")%>
                            </textarea>
                            <div class="form-text">@IperEnma</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Author</label>
                            <input type="text" name="author" class="form-control" value="<%=request.getParameter("author")%>">
                        </div>
                        <a href="index.jsp" type="submit" class="btn btn-danger">Back</a>
                        <button type="submit" class="btn btn-primary" name="send">Update</button>
                    </form>
                </div>
                <div class="g-col-6 g-col-md-4">&nbsp;</div>
            </div>
            <%
                MessagesDao messageDao = new MessagesDao();
                
                String id = request.getParameter("id");
                
                if (request.getParameter("send") != null) {
                    Message message = new Message(
                            Integer.parseInt(id.trim()),
                            request.getParameter("message"),
                            request.getParameter("author")
                    );
                    messageDao.update(message);
                }

            %>  
    </body>
</html>
