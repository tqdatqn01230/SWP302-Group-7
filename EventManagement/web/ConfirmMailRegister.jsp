<%-- 
    Document   : ConfirmMailRegister
    Created on : Sep 20, 2021, 5:48:56 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Your Mail</title>
    </head>
    <body>
        <h1>You almost Create a new account,all You have to do (was follow the damn train) now is check the code sent to your mail and check it</h1>
        <%String error=(String)session.getAttribute("WRONG_CODE"); %>
        <form action="ConfirmMailRegisterController">
            <input type="text" name="Code" placeholder="Your Code here"/>
            <font color="red"><%=error%></font> <br/>
            <input type="submit" name="Action" value="Confirm"/>
            <input type="submit" name="Action" value="Send Again"/>
        </form>
    </body>
</html>
