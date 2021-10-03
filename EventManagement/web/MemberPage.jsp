<%-- 
    Document   : MemberPage
    Created on : Sep 20, 2021, 2:19:38 PM
    Author     : Dell
--%>

<%@page import="models.Follows.FollowDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Page</title>
    </head>
    <header>
        <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
         String fullname;
        if (user!=null){
            fullname=user.getFullName();
        }else fullname="";
        List<Integer> listEventFollow=(List<Integer>) request.getAttribute("ListEventsFollowed");
        List<FollowDTO> listFollow=(List<FollowDTO>) session.getAttribute("ListNotifications");
        %>
        <h1>Welcome <%=fullname%> </h1>
        <form action="CheckNotificationController">
            <p> You have <%=listFollow.size() %> Notifications </p>
            <input type="submit" value="See Notifications" name="Action"/>
        </form>
    </header>
    <body>
        <p>This is member Page</p>
        <form action="LogoutController">
            <input type="submit" value="Logout"/>
        </form>
        <%List<EventsDTO> listEvents=(List<EventsDTO>)request.getAttribute("Events");
        if (listEvents==null||listEvents.size()==0){
        %>
        <h2>There's no available event now,Please come back later or Search for latest events</h2>
        <%}else{
            for (EventsDTO event:listEvents){
            %>
            <div>
                <div><h2>Event post by <%=event.getUserName() %></h2></div>
                <div><h3><%=event.getEventContent() %> </h3> </div>
                <div><p>Followers: <%=event.getFolowers() %></p></div>
                <div><p>Max Followers <%=event.getMaxFollowers() %></p></div>
                <div><p>Location: <%=event.getLocation()%></p></div>
                <div><p>Start time: <%=event.getStarttime()%></p></div>
                <div><p>End time: <%=event.getEndtime()%></p></div>
                <% String button="Follow";
                    if (listEventFollow.contains(event.getEventID())) button="Unfollow"; %>
                <div>
                    <form action='ViewPostsController'>
                        <input type='submit' value='View Posts on Events'/>
                        <input type='hidden' name='EventID' value='<%=event.getEventID() %>'/>
                    </form>
                        <% if (user.getRole().equals("Member")
                             ||((user.getRole().equals("Leader"))
                                &&(user.getUserID()!=event.getUserID()))){%>
                                <form action="FollowEventController">
                                    <input type="submit" name="Action" value="<%=button%>"/>
                                    <input type="hidden" name="EventID" value="<%=event.getEventID()%>"/>   
                                </form>        
                        <% }%>
                </div>
                
            </div>
        <% } } %>

    </body>
</html>
