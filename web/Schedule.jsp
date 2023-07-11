<%-- 
    Document   : Schedule
    Created on : Oct 27, 2021, 9:01:34 PM
    Author     : Dell
--%>

<%@page import="models.user.UserDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.timetable.TimetableDTO"%>
<%@page import="models.Follows.FollowDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>SCHEDULE</title>
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-home.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">

    
    <link rel="stylesheet" href="fonts/icomoon/style.css">
  
    <link href='fullcalendar/packages/core/main.css' rel='stylesheet' />
    <link href='fullcalendar/packages/daygrid/main.css' rel='stylesheet' />
    
    
    <!-- Bootstrap CSS -->
    
    <!-- Style -->
    <link rel="stylesheet" href="css-schedule/style.css">

</head>

<body>
  <div data-component="navbar">
    <nav class="navbar p-0 fixed-top ">
        <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
            
            <div class="right-links float-right mr-4">
               <form class="d-inline dropdown mr-3" action="SearchEventsController">
                    <input type="text" name="Search" placeholder="Search Event" />
                    <button type="submit" class="btn btn-default" style="--blue: ">Search</button>
                </form>                    
                <a href="#" class="home"><i class="mr-3"></i></a>
                <div class="d-inline dropdown rounded-0 mx-3">
            <a 
              href="http://localhost:8080/EventManagerWebPage/ViewEventsController"><i class="fa fa-home" aria-hidden="true"></i></a>
          </div>
                <%List<FollowDTO> listFollow=(List<FollowDTO>) session.getAttribute("ListNotifications"); %>
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
            	<a href="http://localhost:8080/EventManagerWebPage/LogoutController"><i class="fa fa-sign-out"></i></a>
          		</div> 
              	<!-- /.dropdown -->
                <div class="d-inline dropdown">
                    <a class="dropdown-toggle" id="messages" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false" href="#">
                        <img src="img/avatar.png">
                    </a>
                </div> <!-- /.dropdown -->
            </div> <!-- /.right-links -->
        </div>
</div>
                                    <%UserDTO user =(UserDTO)session.getAttribute("USER");  %>
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
    </div> <!-- /.sidebar -->
</div>  
    <div class="container">
        <div class="content">
            <div id='calendar'></div>
          </div>
    </div>

    <!-- partial -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'></script>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

        
        
    
        <script src="js-schedule/jquery-3.3.1.min.js"></script>
        <script src="js-schedule/popper.min.js"></script>
        <script src="js-schedule/bootstrap.min.js"></script>
    
        <script src='fullcalendar/packages/core/main.js'></script>
        <script src='fullcalendar/packages/interaction/main.js'></script>
        <script src='fullcalendar/packages/daygrid/main.js'></script>
        <%List<TimetableDTO> list=(List<TimetableDTO>)request.getAttribute("Schedule"); 
         SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd"); %>
        <script>
          document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
    
        var calendar = new FullCalendar.Calendar(calendarEl, {
          plugins: [ 'interaction', 'dayGrid' ],
          defaultDate: '2021-10-07',
          editable: true,
          eventLimit: true, // allow "more" link when too many events
          events: [
            {
              title: 'All Day Event',
              start: '2021-10-01'
            },
            <%for (TimetableDTO time: list){ 
            String a= time.getStarttime().substring(0, 10);
            %>
            {
                title: '<%=time.getEventName()%>',
                start: '<%=time.getStarttime().substring(0, 10) %>',
                end:'<%=time.getEndtime().substring(0, 10) %>'
            },
            <% }%>
          ]
        });
    
        calendar.render();
      });
    
        </script>
    
        <script src="js-schedule/main.js"></script>
</body>

</html>
