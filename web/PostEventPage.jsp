<%@page import="models.events.EventsDTO"%>
<%@page import="models.Location.LocationDTO"%>
 <%@page import="java.util.List" %>
    <%@page import="models.Follows.FollowDTO" %>
<%@page import="models.user.UserDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>YOUR EVENT</title>
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-event-nav.css">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style-event.css">
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
<style>
    .card {
        box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
        display: grid;
        font-family: 'Trebuchet MS', sans-serif;
        height: 200px;
        margin: 20px auto;
        width: 600px;
    }

    .front {
        grid-template-columns: repeat(12, 1fr);
        grid-template-rows: repeat(4, 1fr);
    }

    .front .blue {
        background-color: #4cc9c8;
        grid-column: 8 / span 5;
        grid-row: 1 / span 4;
    }

    .front .yellow {
        background-color: #f1ef1c;
        grid-column: 1 / span 7;
        grid-row: 1 / span 4;
    }

    .front .pink {
        background-color: #fa001a;
        -webkit-clip-path: polygon(0% 0%, 100% 0%, 0% 100%);
        clip-path: polygon(0% 0%, 100% 0%, 0% 100%);
        grid-row: 1 / span 3;
        grid-column: 1 / span 11;
        position: relative;
        z-index: 2;
    }

    .front .dots {
        background: radial-gradient(#fa001a 20%, transparent 19%), radial-gradient(#fa001a 20%, transparent 19%), transparent;
        background-size: 6px 6px;
        background-position: 0 0, 3px 3px;
        grid-column: 1 / span 12;
        grid-row: 3 / span 2;
        margin: 0 0 15px 20px;
        z-index: 1;
    }

    .front .personal-intro {
        background: black;
        color: white;
        display: flex;
        flex-direction: column;
        grid-column: 4 / span 6;
        grid-row: 2 / span 2;
        justify-content: center;
        text-align: center;
        z-index: 3;
    }

    .front .personal-intro p {
        letter-spacing: 1px;
        text-transform: uppercase;
    }

    .front .personal-intro p:first-of-type {
        font-size: 18px;
    }

    .front .personal-intro p:last-of-type {
        font-size: 8px;
        margin-top: 5px;
    }

    .back {
        grid-template-columns: repeat(12, 1fr);
        grid-template-rows: repeat(12, 1fr);
    }

    .back .yellow {
        background-color: cornflowerblue;
        grid-column: 1 / span 9;
        grid-row: 1 / span 3;
    }

    .back .top.dots {
        background: radial-gradient(#4cc9c8 20%, transparent 19%), radial-gradient(#4cc9c8 20%, transparent 19%), transparent;
        background-size: 6px 6px;
        background-position: 0 0, 3px 3px;
        grid-column: 8 / span 6;
        grid-row: 2 / span 3;
    }

    .back .personal-info {
        grid-column: 2 / span 6;
        grid-row: 5 / span 6;
    }

    .back .personal-info p {
        font-size: 10px;
    }

    .back .personal-info p:first-of-type {
        font-size: 18px;
        font-weight: bold;
        letter-spacing: 1px;
        text-transform: uppercase;
    }

    .back .personal-info p:nth-of-type(2) {
        font-size: 12px;
        margin-bottom: 15px;
    }

    .back .bottom.dots {
        background: radial-gradient(#4cc9c8 20%, transparent 19%), radial-gradient(#4cc9c8 20%, transparent 19%), transparent;
        background-size: 6px 6px;
        background-position: 0 0, 3px 3px;
        grid-column: 1 / span 8;
        grid-row: 11 / span 2;
        z-index: 2;
    }

    .back .pink {
        background-color: darkgrey;
        grid-column: 8 / span 5;
        grid-row: 10 / span 3;
    }
</style>

<body>
    <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
    String fullname;
    if (user!=null){
        fullname=user.getFullName();
    }else fullname="";
    List<Integer> listEventFollow=(List<Integer>) request.getAttribute("ListEventsFollowed");
    List<FollowDTO> listFollow=(List<FollowDTO>) session.getAttribute("ListNotifications");
    List<EventsDTO> listEvent=(List<EventsDTO>)request.getAttribute("YourEventList");
%>
    <div data-component="navbar">
        <nav class="navbar p-0 fixed-top ">
            <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
                <div class="right-links float-right mr-4">
              <form class="d-inline dropdown mr-3" action="">
                    <input type="text" name="Search" placeholder="Search Event" style="outline: none;border: none;
              border-radius: 20px;
              background-color: #D3D3D3;
              height: 40px;
              padding: 15px;" />
                    <button type="submit" style="--blue: ">Search</button>
                </form>
                    <a href="search.html" class="home"><i class="mr-3"></i></a>
                    <div class="d-inline dropdown rounded-0 mx-3">
                      <a 
                        href="search.html"><i class="fa fa-home" aria-hidden="true"></i></a>
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
              </div>  <!-- /.dropdown -->
                    <div class="d-inline dropdown mr-3">
                      <a 
                        href="index.html"><i class="fa fa-sign-out"></i></a>
                    </div> <!-- /.dropdown -->
                    <div class="d-inline dropdown">
                      <a 
                        href="#">
                        <img src="img/avatar.png">
                      </a>
                    </div> <!-- /.dropdown -->
                  </div> <!-- /.right-links -->
                </div>
            </div>
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
                <li class="list-group-item pl-3 py-2">
                  <a href="http://localhost:8080/EventManagerWebPage/LogoutController"><i class="fa fa-sign-out" aria-hidden="true"><span
                              class="ml-2 align-middle">Logout</span></i></a>
              </li>
            </ul> <!-- /.first-menu -->
        </div> <!-- /.sidebar -->
    </div>
        <div class="sidebar"
            style="margin-left: 180px; width: 460px; height: 85%; position: fixed; top: 85px;background-color: white; border-radius: 20px; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;">
            <form id="form" name="form" action="PostEventController">
                <div style="width: 460px;margin: 30px 0px 0px 50px; line-height: 12px;">
                    <div class="form-group" style="width: 75%;">
                        <label>Name Event</label>
                        <input type="text" class="form-control" name="content" required />
                    </div>
                    <div class="main" style="width: 460px;margin: 0px 0px 0px 0px; line-height: 12px;">
                        <div class="form-group" style="width: 75%;">
                            <label for="startDate">Start Date</label>
                            <input id="startDate" name="startDate" type="text" class="form-control" required />
                        </div>
                        <div class="form-group" style="width: 75%;">
                            <label for="endDate">End Date</label>
                            <input id="endDate" name="endDate" type="text" class="form-control" required />
                        </div>
                    </div>
                    <div class="form-group" style="width: 75%;">
                        <label>Participant</label>
                        <input type="number" class="form-control" name="MaxFollower" required />
                    </div>

                    <div class="form-group" style="width: 75%;">
                        <label>Description</label>
                        <textarea class="form-control" name="Description" required></textarea>
                    </div>
                            <%List<LocationDTO>list =(List<LocationDTO>)request.getAttribute("LocationList"); %>
                    <div class="form-group" style="width: 75%;">
                        <label>Location</label>
                        <select class="form-control" name="Location" required>
                            <%for (LocationDTO location:list){ %>
                            <option value="<%=location.getLocationID()%>"><%=location.getLocationName()%></option>
                            <% }%>
                        </select>
                    </div>

                    <button type="submit"
                        style="width: 150px; height: 30px;border: none; background-color: crimson;border-radius: 5px;color: white;">Register</button>
                </div>
            </form>
        </div>
    </div>
    <div class="your-page" style="width: 600px; margin: 65px 0px 0px 530px;">
        <div class="container">
            <div class="row">
                    <%for(EventsDTO event:listEvent){ 
                    String imageLink= (String)request.getAttribute("EventImage"+String.valueOf(event.getEventID()));%>
                <%boolean checkstatus = event.getStatus();
                              boolean checkBan = event.getBanstatus();
              String link="http://localhost:8080/EventManagerWebPage/PrepareLocationController?EventID="+event.getEventID();  
              if (checkstatus) link="http://localhost:8080/EventManagerWebPage/ViewPostsController?EventID="+event.getEventID();%>
                <div class="card back" onclick="location.href='<%=link%>'">
                    <div class="yellow"></div>
                    <div class="top dots">
                        <div style="margin-top: 40px;">
                            <p style="margin: 0px;">Time: <%=event.getStarttime().substring(0, 10)%></p>
                            <p style="margin: 0px;">Location:<%=event.getLocation()%></p>
                            <p style="margin: 0px;">Participant:<%=event.getFolowers()%></p>
                            <%
                            String status="Pending"; 
                            if (checkBan) status="Denied";
                             else if (checkstatus) status="Browsed";  %>
                            <p style="margin: 0px;">Status:<%=status%></p>
                        </div>
                    </div>

                    <div class="personal-info">
                        <p> <%=event.getEventContent()%></p>
                    </div>
                    <div class="bottom dots">

                    </div>
                    <div class="pink">

                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
    <!-- partial -->
    <script src="js/script-event.js"></script>
</body>

</html>