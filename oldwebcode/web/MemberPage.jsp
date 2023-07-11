<!DOCTYPE html>
<html lang="en">
<%@page import="models.Follows.FollowDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page import="models.eventimage.EventImageDTO"%>
<head>
    <meta charset="UTF-16">
    <title>LIST EVENTS</title>
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-home.css">
    <link rel="stylesheet" href="css/style-event.css">

</head>
<%UserDTO user= (UserDTO)session.getAttribute("USER") ;
    String fullname;
    if (user!=null){
        fullname=user.getFullName();
    }else fullname="";
    List<Integer> listEventFollow=(List<Integer>) request.getAttribute("ListEventsFollowed");
    List<FollowDTO> listFollow=(List<FollowDTO>) session.getAttribute("ListNotifications");
    List<EventsDTO> listEvents=(List<EventsDTO>)request.getAttribute("Events");
%>
<body>
<%%>
<div data-component="navbar">
    <nav class="navbar p-0 fixed-top ">
        <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
            <div class="right-links float-right mr-4">

                <form class="d-inline dropdown mr-3" action="SearchEventsController">
                    <input type="text" name="Search"/>
                    <button type="submit" style="--blue: ">Search</button>
                </form>
                <a href="#" class="home"><i class="mr-3"></i></a>
                <div class="d-inline dropdown rounded-0 mx-3">
                    <a class="dropdown-toggle" id="tools" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" href="#"><i class="fa fa-wrench" aria-hidden="true"></i></a>
                </div>
                <div class="d-inline dropdown mr-3">
                    <a class="dropdown-toggle" id="notifications" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" href=""><span><%=listFollow.size() %> </span><i class="fa fa-bell"></i></a>
                       <div class="dropdown-menu dropdown-menu-right rounded-0 pt-0" aria-labelledby="notifications"
                            style="margin: 19px;">
                            <div class="list-group">
                                <div class="lg">
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start active">
                                        <h5 class="mb-1">Real Estate Marketing Automation: 6 Simple Systems</h5>
                                        <p class="mb-0">17 October 2016 | 9:32 pm</p>
                                    </a>
                                    <% for (FollowDTO follow :listFollow ){%>
                                    <a href="http://localhost:8080/EventManagerWebPage/CheckNotificationController?EventID=<%=follow.getEventID() %>"
                                        class="list-group-item list-group-item-action flex-column align-items-start active">
                                        <h5 class="mb-1"><%=follow.getNotification()%></h5>
                                        <p class="mb-0">Click to view Event</p>
                                    </a>    
                                    <% }%>
                                </div> <!-- /.lg -->
                            </div> <!-- /.list group -->
                        </div>
                </div> <!-- /.dropdown -->
                <div class="d-inline dropdown mr-3">
                    <a class="dropdown-toggle" id="messages" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" href="#"><i class="fa fa-envelope"></i></a>
                </div> <!-- /.dropdown -->
                <div class="d-inline dropdown">
                    <a class="dropdown-toggle" id="messages" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" href="#">
                        <img src="img/avatar.png">
                    </a>
                </div> <!-- /.dropdown -->
            </div> <!-- /.right-links -->
        </div>
</div> <!-- END TOP NAVBAR -->



<div data-component="sidebar">
    <div class="sidebar">
        <ul class="list-group flex-column d-inline-block first-menu">
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/ViewEventsController"><i class="fa fa-home" aria-hidden="true"><span
                        class="ml-2 align-middle">Home</span></i></a>
            </li>
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/ProfileController" ><i class="fa fa-user-o" aria-hidden="true"><span
                        class="ml-2 align-middle">Your Profile</span></i></a>
            </li>
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/PrepareLocationController"><i class="fa fa-etsy" aria-hidden="true"><span
                        class="ml-2 align-middle">Event</span></i></a>
            </li>
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/ViewScheduleController"><i class="fa fa-calendar" aria-hidden="true"><span
                        class="ml-2 align-middle">Schedule</span></i></a>
            </li> <!-- /.list-group-item -->
        </ul> <!-- /.first-menu -->
    </div> <!-- /.sidebar -->
</div>
<div class="container">
    <div class="row">
        <%for (EventsDTO event:listEvents){
            String imageLink= (String)request.getAttribute("EventImage"+String.valueOf(event.getEventID())); %>
        <div class="col-md-4">
            <div class="card user-card">
                <div class="card-block">
                    <div class="user-image">
                        <img src="<%=imageLink%>" class="img-radius" alt="User-Profile-Image">
                    </div>
                    <h6 class="f-w-600 m-t-25 m-b-10"><%=event.getEventContent() %> </h6>
                    <p class="text-muted"><%=event.getStarttime()%></p>
                    <p class="text-muted"><%=event.getLocation() %></p>
                    <hr>

                    <div class="bg-c-gray counter-block m-t-10 p-20">
                        <div class="row">
                            <div class="col-4">
                                <i class="fa fa-user"></i>
                                <p><%=event.getFolowers() %>/<%=event.getMaxFollowers() %></p>
                            </div>
                        </div>
                    </div>
                    <p class="m-t-15 text-muted"><%=event.getDescription() %></p>
                    <% String button="Follow";
                    if (listEventFollow.contains(event.getEventID())) button="Unfollow";%>
                    <form action="MiddleController">
                        <input type="hidden" name="EventID" value="<%=event.getEventID()%>"/> 
                        <% if (user.getRole().equals("Member")
                             ||((user.getRole().equals("Leader"))
                                &&(user.getUserID()!=event.getUserID()))){
                        %>
                        <button type="submit" name="Action" value="<%=button%>" class="btn btn-primary"><%=button%></button>
                        
                        <% } else {%>
                            <%}%>
                        <button type="submit" name="Action" value="ViewPost" class="btn btn-outline-primary">VIEW POST</button>
                    </form>
                </div>
            </div>
        </div>
        <% } %>

    </div>
</div>
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</body>

</html>