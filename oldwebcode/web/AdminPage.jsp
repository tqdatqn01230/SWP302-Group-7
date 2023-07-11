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
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>ADMIN</title>
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
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
            var actions = $("table td:last-child").html();
            // Add row on add button click
            // Edit row on edit button click
        });
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
    </script>
</head>

<body>
    <div data-component="navbar">
        <nav class="navbar p-0 fixed-top ">
            <div class="brand"><a class="navbar-brand px-1 logo" href="#">MEETUP <span>.</span></a>
                <div class="right-links float-right mr-4">
                    <a href="#" class="home"><i class="mr-3"></i></a>
                    <div class="d-inline dropdown rounded-0 mx-3">
                        <a class="dropdown-toggle" id="tools" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" href="#"><i class="fa fa-wrench" aria-hidden="true"></i></a>
                    </div>
                    <div class="d-inline dropdown mr-3">
                        <a class="dropdown-toggle" id="notifications" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" href="#"><span>10</span><i class="fa fa-bell"></i></a>

                        <div class="dropdown-menu dropdown-menu-right rounded-0 pt-0" aria-labelledby="notifications"
                            style="margin: 19px;">
                            <div class="list-group">
                                <div class="lg">
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start active">
                                        <h5 class="mb-1">Real Estate Marketing Automation: 6 Simple Systems</h5>
                                        <p class="mb-0">17 October 2016 | 9:32 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">How to Generate Seller Leads For $0.88 Using...</h5>
                                        <p class="mb-0">3 October 2016 | 9:58 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">AgentFire Re-Opens For Business. New Services,...</h5>
                                        <p class="mb-0">20 September 2016 | 6:28 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">Real Estate Blogging 101: How To Get Better...</h5>
                                        <p class="mb-0">7 September 2016 | 3:03 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">How To Get More Listings With Strategic...</h5>
                                        <p class="mb-0">16 August 2016 | 8:26 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">How To Find Strategic Real Estate Partners as...</h5>
                                        <p class="mb-0">9 August 2016 | 6:44 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">Top 10 Real Estate Marketing Tools</h5>
                                        <p class="mb-0">2 August 2016 | 10:25 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">The Beginner Guide To Google Adwords For Real...</h5>
                                        <p class="mb-0">27 July 2016 | 1:15 am</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">The Complete Guide To Hyper-Local SEO For Realtors</h5>
                                        <p class="mb-0">19 July 2016 | 5:51 pm</p>
                                    </a>
                                    <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                        <h5 class="mb-1">How We Took Ed Eakin’s Real Estate Website...</h5>
                                        <p class="mb-0">11 July 2016 | 6:19 pm</p>
                                    </a>
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
    </div>
<div data-component="sidebar">
        <div class="sidebar">
            <ul class="list-group flex-column d-inline-block first-menu">
                <li class="list-group-item pl-3 py-2">
                    <a href="http://localhost:8080/EventManagerWebPage/ViewUserController"><i class="fa fa-home" aria-hidden="true"><span
                                class="ml-2 align-middle">Users</span></i></a>
                </li>
                <li class="list-group-item pl-3 py-2">
                    <a href="http://localhost:8080/EventManagerWebPage/ViewPendingEventsController"><i class="fa fa-user-o" aria-hidden="true"><span
                                class="ml-2 align-middle">Events</span></i></a>
                </li>
                <!-- /.list-group-item -->
            </ul> <!-- /.first-menu -->
        </div>
    <div class="container mt-5">
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
        <div class="container-lg">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8">
                                <h2>User <b>Details</b></h2>
                            </div>
                        </div>
                    </div>
                    <%List<UserDTO>listUser=(List<UserDTO>)session.getAttribute("UserList"); %>
                    <table id="myTable" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th style="width: 300px;">Email</th>
                                <th>Role</th>
                                <th>Password</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%for (UserDTO user:listUser){ %>
                            <tr>
                                <form action="MainAdminController">
                                <td><%=user.getFullName() %></td>
                                <td><%=user.getGmail() %></td>
                                <td class="role"><input type="text" value="<%=user.getRole()%>" name="Role"></td>
                                <td>******</td>
                                <input type="hidden" name="UserID" value="<%=user.getUserID()%>">
                                <td>
                                    <button type="submit" name="Action" value="Delete" style="border: none; background-color: white;width: 100%;">
                                        <a class="delete" title="Delete" data-toggle="tooltip"><i
                                                class="material-icons">&#xE872;</i></a>
                                    </button>
                                    <button type="submit" name="Action" value="Update" style="border: none; background-color: white;width: 100%;">
                                        <a class="edit" title="Edit" data-toggle="tooltip"><i
                                                class="material-icons">&#xE254;</i></a>                               
                                    </button>
                                        <a class="add" title="Add" data-toggle="tooltip"><i
                                                class="material-icons">&#xE03B;</i></a>
                                    
                                </td>
                                </form>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>