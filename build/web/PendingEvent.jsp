<%-- 
    Document   : PendingEvent.jso
    Created on : Nov 1, 2021, 4:14:14 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Follows.FollowDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page import="models.eventimage.EventImageDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>ADMIN - EVENTS</title>
    <link rel='stylesheet'
        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-home.css">
    <link rel="stylesheet" href="css/style-soon.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
    <style>
        .table-wrapper {
            width: 100%;
            margin: 0px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 10px;
            margin: 0 0 10px;
        }

        .table-title h2 {
            margin: 6px 0 0;
            font-size: 22px;
        }

        .table-title .add-new {
            float: right;
            height: 30px;
            font-weight: bold;
            font-size: 12px;
            text-shadow: none;
            min-width: 100px;
            border-radius: 50px;
            line-height: 13px;
        }

        .table-title .add-new i {
            margin-right: 4px;
        }

        table.table {
            table-layout: fixed;
        }

        table.table tr th,
        table.table tr td {
            border-color: #e9e9e9;
            word-wrap: break-word;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table th:last-child {
            width: 100px;
        }

        table.table td a {
            cursor: pointer;
            display: inline-block;
            margin: 0 5px;
            min-width: 24px;
        }

        table.table td a.add {
            color: #27C46B;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #E34724;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table td a.add i {
            font-size: 24px;
            margin-right: -1px;
            position: relative;
            top: 3px;
        }

        table.table .form-control {
            height: 32px;
            line-height: 32px;
            box-shadow: none;
            border-radius: 2px;
        }

        table.table .form-control.error {
            border-color: #f50000;
        }

        table.table td .add {
            display: none;
        }

        #myInput {
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 20px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }

        @media screen and (max-width: 600px) {
            input[type=text] {
                width: 150px;
            }
        }
    </style>
    <script>
        function myFunction() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
        $(function () {
            $('#all').on('click', function () {
                $("input[name='chk[]']").prop('checked', this.checked);
            });
            $("input[name='chk[]']").on('click', function () {
                if ($('#boxes :checked').length == $('#boxes :input').length) {
                    $('#all').prop('checked', true);
                } else {
                    $('#all').prop('checked', false);
                }
            });
        });
    </script>
</head>

<body>
    <div data-component="navbar">
        <nav class="navbar p-0 fixed-top ">
            <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
                <div class="right-links float-right mr-4">
                    <div class="d-inline dropdown mr-3">
                        <a class="dropdown-toggle" id="notifications" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" href="#"><span>0</span><i class="fa fa-bell"></i></a>
                        
                    </div> <!-- /.dropdown -->
                    <div class="d-inline dropdown mr-3">
                        <a  href="http://localhost:8080/EventManagerWebPage/LogoutController"><i class="fa fa-sign-out"></i></a>
                    </div> <!-- /.dropdown -->
                    <div class="d-inline dropdown">
                        <a href="#">
                            <img src="img/avatar.png">
                        </a>
                    </div> <!-- /.dropdown -->
                </div> <!-- /.right-links -->
            </div>
        </nav>
    </div>
    <div data-component="sidebar">
        <div class="sidebar">
            <ul class="list-group flex-column d-inline-block first-menu">
                <li class="list-group-item pl-3 py-2">
                    <a href="http://localhost:8080/EventManagerWebPage/ViewUserController"><i class="fa fa-user-o" aria-hidden="true"><span
                                class="ml-2 align-middle">Users</span></i></a>
                </li>
                <li class="list-group-item pl-3 py-2">
                    <a href="http://localhost:8080/EventManagerWebPage/ViewPendingEventsController"><i class="fa fa-calendar-o" aria-hidden="true"><span
                                class="ml-2 align-middle">Events</span></i></a>
                </li>
              <!-- <li class="list-group-item pl-3 py-2">
                    <a href="http://localhost:8080/EventManagerWebPage/ViewEventsController"><i class="fa fa-check" aria-hidden="true"><span
                                class="ml-2 align-middle">Approve</span></i></a>
                </li>-->
                <!-- /.list-group-item -->
            </ul> <!-- /.first-menu -->
        </div> <!-- /.sidebar -->
    </div>
    <div class="container mt-5">
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
        <div class="container-lg">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-9">
                                <h2>Event <b>Approve</b></h2>
                            </div>
                            <div class="col-sm-3">
                                <form action="BrowsingEventController" id="myForm">
                                <button type="submit" value="Accept" name="Action" class="btn btn-success" style="width: 100px;">Accept</button>
                                <button type="submit" value="Deny" name="Action" class="btn btn-danger" style="width: 100px;">Deny</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <table id="myTable" class="table table-bordered">
                        <thead>
                            <tr>
                                <th style="width: 25%;">Name Events</th>
                                <th style="width: 25%;">Description</th>
                                <th style="width: 19%;">Time</th>
                                <th style="width: 11%;">Participant</th>
                                <th style="width: 15%;">Location</th>
                                <th style="width: 5%;"><input type="checkbox" id="all"></th>
                            </tr>
                        </thead>
                        <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
                         String fullname;
                         if (user!=null){
                         fullname=user.getFullName();
                          }else fullname="";
    List<EventsDTO> listEvents=(List<EventsDTO>)request.getAttribute("PendingEvents");
                       
                   for (EventsDTO event:listEvents) {
            String imageLink= (String)request.getAttribute("EventImage"+String.valueOf(event.getEventID())); 
                    %>
                        <tbody id="boxes">
                            <tr>
                                <td><%=event.getEventContent() %></td>
                                <td><%=event.getDescription() %></td>
                                <td><%=event.getStarttime().substring(0,10)%>-<%=event.getEndtime().substring(0,10)%></td>
                                <td><%=event.getMaxFollowers()%></td>
                                <td><%=event.getLocation()%></td>
                        <input type="hidden" name="EventID" value="<%=event.getEventID()%>" form="myForm"/>
                        <td><input type="checkbox" name="chk[]" value="A" form="myForm">
                                <td>
                            </tr>
                          <%}%>  
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>