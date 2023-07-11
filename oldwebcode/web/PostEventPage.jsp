<%@page import="models.events.EventsDTO"%>
<%@page import="models.Location.LocationDTO"%>
<!DOCTYPE html>
<html lang="en">
    <%@page import="java.util.List" %>
    <%@page import="models.Follows.FollowDTO" %>
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="style-event-nav.css">
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
    <link rel="stylesheet" href="style-event.css">
</head>

<body>
    <div data-component="navbar">
        <nav class="navbar p-0 fixed-top ">
            <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
                <div class="right-links float-right mr-4">
                    <a href="#" class="home"><i class="fa fa-home mr-3"></i></a>
                    <div class="d-inline dropdown rounded-0 mx-3">
                        <a class="dropdown-toggle" id="tools" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" href="#"><i class="fa fa-wrench" aria-hidden="true"></i></a>
                    </div>
                    <% List<FollowDTO> listFollow=(List<FollowDTO>) session.getAttribute("ListNotifications");%>
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
</div><!-- /.sidebar -->
       
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
                            <%List<EventsDTO> listEvent=(List<EventsDTO>)request.getAttribute("YourEventList"); %>
    <div class="your-page" style="width: 600px; margin: 85px 0px 0px 500px;">
        <div class="container">
            <div class="card" style="margin: 20px;">
                <div class="row">
                    <div class="col-sm-4">
                        <img class="d-block w-100" src="post-fcode-2.png" alt="">
                    </div>
                    <div class="col-sm-5">
                        <div class="card-block">
                            <!--           <h4 class="card-title">Small card</h4> -->
                            <p>EVENT Name</p>
                            <p>TIME-LOCATION</p>
                            <p>PARTICIPANT</p>
                            <a href="detail.html" class="">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        <%for(EventsDTO event:listEvent){ 
        String imageLink= (String)request.getAttribute("EventImage"+String.valueOf(event.getEventID()));%>
            <div class="card" style="margin: 20px;">
                <div class="row">
                    <div class="col-sm-4">
                        <img class="d-block w-100" src="<%=imageLink%>" alt="">
                    </div>
                    <div class="col-sm-5">
                        <div class="card-block">
                            <!--           <h4 class="card-title">Small card</h4> -->
                            <p><%=event.getEventContent()%></p>
                            <p><%=event.getStarttime()%>-<%=event.getLocation()%> </p>
                            <p><%=event.getFolowers()%>/<%=event.getMaxFollowers()%> </p>
                            <%if (!event.getStatus()) {%>
                             Pending Event<br/>
                            <%}%>
                            <a href="http://localhost:8080/EventManagerWebPage/ViewPostsController?EventID=<%=event.getEventID()%>" 
                               class="">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        <% }%>
        </div>
    </div>
            <form action="AddImageOnEventController"  method="post" enctype="multipart/form-data">
                 <input type="file" id="image" name="file" size="60" accept="image/*" required />
                 <input type="submit"/>
            </form>
    <!-- partial -->
    <script src="js/script-event.js"></script>
</body>

</html>