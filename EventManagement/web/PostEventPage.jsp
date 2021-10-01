<%-- 
    Document   : PostEventPage
    Created on : Sep 30, 2021, 1:19:42 PM
    Author     : Dell
--%>

<%@page import="java.util.List"%>
<%@page import="models.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <header>
        <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
         String fullname;
        if (user!=null){
            fullname=user.getFullName();
        }else fullname="";
        %>
        <h1>Welcome <%=fullname%> </h1>
    </header>
        <%List<String> list=(List<String>)request.getAttribute("LocationList");%>
    <body>
        <p>This is Club Leader Page</p>
        <form action="LogoutController">
            <input type="submit" value="Logout"/>
        </form>
        <form action="PostEventController">
            <input type="text" name="Content" placeholder="Enter Event's Content here" height="300" width="900"/><br/>
            Max Follower<input type="number" name="MaxFollower" step="1" min="1"/><br/>
            Start date<input type="date" name="Startdate" /><br/>
            End date <input type="date" name="Enddate" /> <br/>
            Location:<select name="Location">
                <%for (String location:list){%>
                <option value="<%=location%>"><%=location%></option>
                <% }%>
            </select><br/>
            <input type="submit" name="whatever" value="Post Event"/>
        </form>
            <form action='ViewYourEventsController'>
                <input type='submit' value='View Your Events'/>
            </form>
                <h2>${requestScope.Mess}</h2>
    </body>
</html>
