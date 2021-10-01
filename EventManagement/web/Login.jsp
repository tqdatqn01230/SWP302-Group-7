<%-- 
    Document   : login
    Created on : Sep 19, 2021, 7:58:59 PM
    Author     : Dell
--%>

<%@page import="models.user.UserDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header class="loginheader">
        <h1>
            <font color = "blue">
                Login Page
            </font>
        </h1>
    </header>
    <body>
        <section class="login">
        <form action="LoginController" method="get"/>
            UserName<input type="text" name="UserName"/><br/>
            Password<input type="password" name="Password"/><br>
            <input type="submit" name="Action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/EventManagerWebPage/LoginByMailController&response_type=code&client_id=320372249105-n9lqj4retbe65vf3coa4go6q6e6jca0i.apps.googleusercontent.com&approval_prompt=force">
            Login With Google</a> 
        <form action="RegisterPage.jsp" method="Post">
            <input type="submit" name="Action" value="Register"/><br/>
        </form>
        <% String error=(String)session.getAttribute("LOGIN_ERROR"); 
           if (error==null) error="";%>
           <p>
               <font color="red">
               <%=error%>
               </font>
           </p> 
        </section>
    </body>   
</html>
