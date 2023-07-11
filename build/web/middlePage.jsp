<%-- 
    Document   : middlePage
    Created on : Nov 10, 2021, 11:47:32 PM
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
        <h1>Hello World!</h1>
        <% int a= (int)request.getAttribute("EventID");
        %>
        <form action="ViewPostsController" id="myform" name="my_form">
            <input type="hidden" name="EventID" value="<%=a%>"/>
            <button type="submit">button</button>
        </form>
            <script>
                window.onload = function(){
                   var form = document.getElementById("myform");
                    form.submit();
                    }
            </script>
    </body>
</html>
