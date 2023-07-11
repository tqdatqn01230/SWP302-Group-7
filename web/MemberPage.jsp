<%@page import="org.springframework.messaging.simp.annotation.support.SimpAnnotationMethodMessageHandler"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.Follows.FollowDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page import="models.eventimage.EventImageDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link rel="shortcut icon" href="http://sstatic.net/stackoverflow/img/favicon.ico">
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-home.css">
    <link rel="stylesheet" href="css/style-search.css">
    <script src="js/script-search.js"></script>
    <link rel="apple-touch-icon" sizes="57x57" href="img/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="img/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="img/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="img/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="img/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="img/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="img/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="img/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="img/favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
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
    <div data-component="navbar">
        <nav class="navbar p-0 fixed-top ">
          <div class="brand"><a class="navbar-brand px-1 logo" href="http://localhost:8080/EventManagerWebPage/ViewEventsController">MEETUP <span>.</span></a>
            <div class="right-links float-right mr-4">
              
              <form class="d-inline dropdown mr-3" action="SearchEventsController">
                    <input type="text" name="Search" placeholder="Search Event" />
                    <button type="submit" class="btn btn-default" style="--blue: ">Search</button>
                </form>
              <a href="ViewEventsController" class="home"><i class="mr-3"></i></a>
              <div class="d-inline dropdown mr-3">
                <%if (user!=null){%>
                  <a class="dropdown-toggle" id="notifications" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" href=""><span><%=listFollow.size() %> </span><i class="fa fa-bell"></i></a>
                <%}%>
                       <div class="dropdown-menu dropdown-menu-right rounded-0 pt-0" aria-labelledby="notifications"
                            style="margin: 19px;">
                            <div class="list-group">
                                <div class="lg">
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
               <%if (user!=null){ %>
                <a 
                  href="http://localhost:8080/EventManagerWebPage/LogoutController">                    
                    <i class="fa fa-sign-out"></i>
                     </a>
                    <%}else{%>
                    <button type="button" class="btn btn-outline-danger btn-rounded waves-effect"><a href="http://localhost:8080/EventManagerWebPage/LogoutController" style="text-decoration: none; color: #f95959;">LOGIN</a></button>
                    <%}%>
               
              </div> <!-- /.dropdown -->
              <%if(user!=null){%>
              <div class="d-inline dropdown">
                <a 
                  href="http://localhost:8080/EventManagerWebPage/ProfileController">
                  <img src="img/avatar.png">
                </a>
              </div> <!-- /.dropdown -->
              <%}%>
            </div> <!-- /.right-links -->
          </div>
      </div>
    <%if (user!=null){ %>
    <div data-component="sidebar">
        <div class="sidebar">
            <ul class="list-group flex-column d-inline-block first-menu">
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/ViewEventsController"><i class="fa fa-home" aria-hidden="true"><span
                        class="ml-2 align-middle">Home</span></i></a>
            </li>
            <%if (user!=null){%>
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/ProfileController" ><i class="fa fa-user-o" aria-hidden="true"><span
                        class="ml-2 align-middle">Your Profile</span></i></a>
            </li>
            <%if (user.getRole().equals("Leader")){%>
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/PrepareLocationController"><i class="fa fa-etsy" aria-hidden="true"><span
                        class="ml-2 align-middle">Event</span></i></a>
            </li>
            <%}%>
            <li class="list-group-item pl-3 py-2">
                <a href="http://localhost:8080/EventManagerWebPage/ViewScheduleController"><i class="fa fa-calendar" aria-hidden="true"><span
                        class="ml-2 align-middle">Schedule</span></i></a>
            </li>
            <%}%>
            <!-- /.list-group-item -->
                <li class="list-group-item pl-3 py-2">
                  <%if(user!=null){ %>
                    <a href="http://localhost:8080/EventManagerWebPage/LogoutController"><i class="fa fa-sign-out" aria-hidden="true"><span
                              class="ml-2 align-middle">Logout</span></i></a>
                  <% }else{%>
                  <a href="http://localhost:8080/EventManagerWebPage/LogoutController"><i class="fa fa-sign-in" aria-hidden="true"><span
                              class="ml-2 align-middle">Login</span></i></a>
                    <%}%>
              </li>
            </ul> <!-- /.first-menu -->
        </div> <!-- /.sidebar -->
    </div>
              <%}%>
    <div class="container">
          <div class="card-list">
            <%for (EventsDTO event:listEvents){
            String imageLink= (String)request.getAttribute("EventImage"+String.valueOf(event.getEventID())); %>
            <div class="card" id="card-1">
              <div class="avatar">
                <img src="<%=imageLink%>" style="height: 130px; width: 130px;"/>
              </div>
              <div class="header">
     
                <h4><%=event.getEventContent() %></h4>
                <div class="title">Time : <%=event.getStarttime().substring(0, 10) %>- <%=event.getEndtime().substring(0, 10) %></div>
                <div class="title">Location : <%=event.getLocation() %></div>
                <div class="title"><i class="fa fa-user" aria-hidden="true"></i> <%=event.getFolowers() %>/<%=event.getMaxFollowers() %></div>
                <%String status="On-Going";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(event.getEndtime());
                LocalDateTime dateToConver = LocalDateTime.now();
                Date currentdate=java.sql.Timestamp.valueOf(dateToConver) ;
                if (currentdate.after(date) ) status="Ended"; %>
                <div class="title">Status: <%=status%></div>
              </div>
              <div class="colorband"></div>
              <div class="desc"><%=event.getDescription()%></div>
              <% String button="Follow";
                    if (listEventFollow.contains(event.getEventID())) button="Unfollow";%>
                    
                    <form action="MiddleController" >
                        <input type="hidden" name="EventID" value="<%=event.getEventID()%>"/> 
                    
              <div class="actions">
                  <% if ((user!=null)&&((user.getRole().equals("Member")
                             ||((user.getRole().equals("Leader"))
                                &&(user.getUserID()!=event.getUserID())))&&(event.getMaxFollowers()>event.getFolowers()))){
                        %>
                <button  name="Action" value="<%=button%>"><span><i class="fa fa-plus" aria-hidden="true" ></i><span> <%=button%></span></span></button>
                <%}else{%>
                    <button disabled name="Action" value="<%=button%>"><span><i class="fa fa-plus" aria-hidden="true" ></i><span> <%=button%></span></span></button>
                <%}%>
            </form>
            
                <a href="http://localhost:8080/EventManagerWebPage/ViewPostsController?EventID=<%=event.getEventID()%>"><button name="Action" value="View"><span><i class="fa fa-eye" aria-hidden="true"></i>
                            <span> View</span></span></button></a>
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