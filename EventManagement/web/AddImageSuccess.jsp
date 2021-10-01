<%-- 
    Document   : AddImageSuccess
    Created on : Sep 28, 2021, 9:30:14 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You Add Image Success</h1>
        <%String eventID=(String) request.getAttribute("EventID"); %>
        <form action="ViewPostsController">
            <input type="hidden" name="EventID" value="<%=eventID %>"/>
            <input type="submit" value="Back to View Posts"/>
        </form>
    </body>
</html>
