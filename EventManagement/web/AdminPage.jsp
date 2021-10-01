<%-- 
    Document   : AdminPage
    Created on : Sep 22, 2021, 4:59:04 PM
    Author     : Dell
--%>

<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
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
        List<EventsDTO>list= (List<EventsDTO>) request.getAttribute("PendingEvents");
        %>
        <h1>Welcome <%=fullname%> </h1>
    </header>
    <body>
        <p>This is Admin Page</p>
        <form action="LogoutController">
            <input type="submit" value="Logout"/>
        </form>
        <%if (list==null){
            %>
            <h2>No pending event</h2>
         <%}else{
                for (EventsDTO event:list){
            %>
            <h2><%=event.getEventContent()%></h2>
            <p>Max Followers: <%=event.getMaxFollowers()%></p><br/>
            <p>Location : Unavailable now</p>
            <form action='BrowsingEventController'>
                <input type="hidden" name='EventID' value="<%=event.getEventID()%>"/>
                <input type='submit' value='Browse'/>
            </form>
         <% } }%>
    </body>
</html>
