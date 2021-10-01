<%-- 
    Document   : ViewNotifications
    Created on : Sep 29, 2021, 7:56:43 PM
    Author     : Dell
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Follows.FollowDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Notifications</title>
    </head>
    <body>
       <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
         String fullname;
        if (user!=null){
            fullname=user.getFullName();
        }else fullname="";
        List<FollowDTO> list=new ArrayList();
         list= (List<FollowDTO>) session.getAttribute("ListNotifications");
         session.removeAttribute("ListNotifications");
       %>
        <h1>Hello <%=user.getFullName()%></h1>
        <form action="ViewEventsController">
            <input type="submit" name="Action" value="Back to View Event"/>
        </form>
        <%if(list!=null){
          for (FollowDTO follow:list){%>
        <form action="ViewPostsController">
            <p><%=follow.getNotification()%></p>
            <input type="hidden" value="<%=follow.getEventID()%>" name="EventID" />
            <input type="submit" name="Action" value="Go to Event"/>
        </form>
        <% } }%>
    </body>
</html>
