<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : ViewYourPosts
    Created on : Sep 27, 2021, 8:15:34 PM
    Author     : Dell
--%>

<%@page import="models.events.EventsDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Post</title>
    </head>
    <body>
        
         <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
         String fullname;
        if (user!=null){
            fullname=user.getFullName();
        }else fullname="";
        %>
        <h1>Welcome <%=fullname%> </h1>
        <h1> Here're Your Event</h1>
        <%List<EventsDTO> list=(List<EventsDTO>)request.getAttribute("YourEventList");%>
        <%for (EventsDTO event:list){%>
        <form action="ViewPostsController">
            <p><%=event.getEventContent()%><p><br/>
            Follower: <p><%=event.getFolowers()%></p>
            Max Follower: <p><%=event.getMaxFollowers()%></p>
            <input type='hidden' name='EventID' value='<%=event.getEventID()%>'/>
            <input type='submit' name='Action' value='View Posts on Event'/>
        </form>    
        <% }%>
        <form action="PrepareLocationController">
            <input type="submit" name="Action" value="Add new Event"/>
        </form>
    </body>
</html>
