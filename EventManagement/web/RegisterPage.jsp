<%-- 
    Document   : create
    Created on : May 12, 2021, 6:38:02 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.user.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create account</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header class="createaccountheader">
        <h1>Create a new Account</h1>
    </header>
    <body>
        
        <%RegisterError error=(RegisterError)session.getAttribute("ERROR"); 
            //UserErrorDTO error=(UserErrorDTO)request.getAttribute("Error");
        if (error==null){
            error=new RegisterError();
        }
        String username=(String)session.getAttribute("USERNAME");
            String password=(String)session.getAttribute("PASSWORD");
            String confirm=(String)session.getAttribute("CONFIRM");
            String email=(String)session.getAttribute("EMAIL");
            String fullname=(String)session.getAttribute("FULLNAME");
            if (username==null) username="";
            if (password==null) password="";
            if (confirm==null) confirm="";
            if (email==null) email="";
            if (fullname==null) fullname="";
          
        %>
 
        <form action="RegisterController">
            Username<input type="text" name="UserName" value="<%=username%>" required=""/><br/>
            <font color="red"><%=error.getUsername() %></font><br/>
            Password<input type="password" name="Password" value="<%=password%>" required=""/><br>
            <font color="red"><%=error.getPassword() %></font><br/>
            Confirm<input type="password" name="Confirm" required="" value="<%=confirm%>"><br/>
            <font color="red"><%=error.getConfirmpassword()%></font><br/>
            Full Name<input type="text" name="FullName" value="<%=fullname%>"><br/>
            <font color="red"><%=error.getFullname() %></font> <br/>
            Email<input type="email" name="Email" required="" value="<%=email%>"/><br/>
            <font color="red"><%=error.getGmail()%></font> <br/>
            <input type="submit" name="Action" value="Register"/> 
        </form>
            <form action="Login.jsp">
                <input type="submit" name="whaever" value="Back to login"/>
            </form>
    </body>
</html>

