<%-- 
    Document   : ViewPostsPage
    Created on : Sep 23, 2021, 4:51:31 PM
    Author     : Dell
--%>

<%@page import="models.Follows.FollowDTO"%>
<%@page import="models.imageandVideo.ImageAndVideoDTO"%>
<%@page import="models.replys.ReplyDTO"%>
<%@page import="models.Comments.CommentDTO"%>
<%@page import="models.posts.PostDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>DETAIL EVENT</title>
    <link rel='stylesheet'
      href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style-home.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/demo.css">
    <link rel="apple-touch-icon" sizes="57x57" href="img/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="img/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="img/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="img/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="img/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="img/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="img/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="img/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="img/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="img/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="img/favicon-16x16.png">
    <link rel="manifest" href="/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
  </head>

<body>
  <div data-component="navbar">
    <nav class="navbar p-0 fixed-top ">
      <div class="brand"><a class="navbar-brand px-1 logo" href="http://localhost:8080/EventManagerWebPage/ViewEventsController">MEETUP <span>.</span></a>

        <div class="right-links float-right mr-4">
          <form class="d-inline dropdown mr-3" action="SearchEventsController">
                    <input type="text" name="Search" placeholder="Search Event" />
                    <button type="submit" class="btn btn-default" style="--blue: ">Search</button>
                </form>          <a href="#" class="home"><i class="mr-3"></i></a>
          <div class="d-inline dropdown rounded-0 mx-3">
            <a class="dropdown-toggle" id="tools" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
              href="#"><i class="fa fa-wrench" aria-hidden="true"></i></a>
          </div>
          <% UserDTO user= (UserDTO)session.getAttribute("USER");
              List<FollowDTO> listFollow =(List<FollowDTO>)session.getAttribute("ListNotifications"); %>
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
                                    <% 
                                        for (FollowDTO follow :listFollow ){%>
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
                  href="http://localhost:8080/EventManagerWebPage/LogoutController"><i class="fa fa-sign-out"></i></a>
              </div>
          <div class="d-inline dropdown">
            <a class="dropdown-toggle" id="messages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
              href="#">
              <img src="img/avatar.png">
            </a>
          </div> <!-- /.dropdown -->
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
              
    <%}
         String fullname;
        if (user!=null){
            fullname=user.getFullName();
        }else {
            user= new UserDTO(-1);
        }
        EventsDTO event=(EventsDTO)request.getAttribute("Event");
        boolean check=false;
        if (event.getUserID()==user.getUserID()) check=true;
        String EventImage= (String)request.getAttribute("EventImage");
        %>
  <div class="container">
    <div class="main-body">
      <div class="row">
        <div class="col-lg-4">
          <div class="card">
            <div class="card-body">
              <div class="d-flex flex-column align-items-center text-center">               
                <div class="avatar-wrapper">
                <form action="AddImageOnEventController" method="post" id="AddEventImage" enctype="multipart/form-data">
                  <img class="profile-pic" src="<%=EventImage%>" />
                  <input type="hidden" name="EventID" value="<%=event.getEventID()%>"/>
                  <div class="upload-button">
                    <i class="fa fa-arrow-circle-up" aria-hidden="true"></i>
                  </div>
                  <input class="file-upload" type="file" accept="image/*" name="file"/>
                </form>
                </div>
                <div class="mt-3">
                  <h4><%=event.getEventContent()%></h4>
                  <p class="text-muted font-size-sm"><%=event.getStarttime().substring(0,10)%> - <%=event.getEndtime().substring(0,10) %></p>
                  <form action="SendNotificationController" id="SendMessage">
                      <input type="hidden" value="<%=event.getEventID()%>" name="EventID"/>
                  </form>
                  
                  <%if (check) {%>
                  <button class="btn btn-primary" form="SendMessage">Send Notification</button>
                  <button type="submit" form="AddEventImage" class="btn btn-outline-primary">Set Avatar</button>
                  <%}%>
                </div>
              </div>
              <hr class="my-4">
              <ul class="list-group list-group-flush">
                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 class="mb-0">Location</h6>
                  <span class="text-secondary"><%=event.getLocation()%></span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 class="mb-0">Participant</h6>
                  <span class="text-secondary"><%=event.getFolowers()%>/<%=event.getMaxFollowers()%></span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                  <h6 class="mb-0">Description</h6>
                  <span class="text-secondary"><%=event.getDescription() %></span>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-8">
          <div class="card">
            <div class="card-body">
              <div class="row mb-3">
                <div class="col-sm-10 text-secondary">
                    <form action="PostController">
                        <input type="hidden" value="<%=event.getEventID()%>" name="EventID">
                  <input type="text" name="PostContent" class="form-control" placeholder="say something ...">
                </div>
                <div class="col-sm-2 text-secondary" style="padding:0px 0px;">
                    <%if (check){%>
                    <input type="submit"  class="btn btn-primary px-4" value="Post">
                    <%}%>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-sm-12">
                <%List<PostDTO> list_post=(List<PostDTO>)request.getAttribute("List_Posts");
                int No=0,NoRep=0;
           for (PostDTO post:list_post){
               String ListNameImage="ImagesID:"+String.valueOf(post.getPostID());
               ImageAndVideoDTO Image=(ImageAndVideoDTO) request.getAttribute(ListNameImage);
                %>             
                <div class="card">
                  <div class="d-flex justify-content-between p-2 px-3">
                    <div class="d-flex flex-row align-items-center"> <img src="img/avatar-fcode.png" width="50"
                        class="rounded-circle">
                        <div class="d-flex flex-column ml-2"> <span class="font-weight-bold"><%=event.getUserName() %></span>
                        
                      </div>
                    </div>
                    
                    <div class="d-flex flex-row mt-1 ellipsis"> <small class="mr-2">20 mins</small> <i
                        class="fa fa-ellipsis-h"></i> </div>
                     <%if (user.getUserID()==event.getUserID()){%>   
                        <form action="DeletePostController">
                            <input type="hidden" value="<%=post.getPostID()%>"name="PostID" />
                            <input type="hidden" value="<%=event.getEventID()%>" name="EventID"/>
                            <button type="submit" style="background-color: white; border: none;"><i
                            class="fa fa-remove"></i></button>
                    </form>
                            <%}%>
                  </div> <img src="<%=Image.getLink()%>" class="img-fluid">
                  <form method="post" enctype="multipart/form-data" action="AddImageOnPostController">
                    <div class="form-group">
                      <label><strong>Upload Files</strong></label>
                      <div class="custom-file">
                          <input type='hidden' name="PostID" value="<%=post.getPostID()%>"/>
                          <input type='hidden' name='EventID' value='<%=event.getEventID()%>'/>
                        <input type="file" name="file" accept="image/*">
                      </div>
                    </div>
                    <%if (user.getUserID()==event.getUserID()){%>
                    <div class="form-group">
                        <button type="submit" style="width: 100%;" class="btn btn-primary"><i class="fa fa-fw fa-upload"></i> Upload</button>
                    </div>
                    <%}%>
                  </form>
                  <div class="p-2">
                    <p class="text-justify"><%=post.getPostContent()%></p>
                    <hr>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="d-flex flex-row icons d-flex align-items-center"> <i class="fa fa-heart"></i> <i
                          class="fa fa-smile-o ml-2"></i> </div>
                      <div class="d-flex flex-row muted-color"> <span>2 comments</span> <span class="ml-2">Share</span> </div>
                    </div>
                    <hr>
                    <%  String so=String.valueOf(post.getPostID());
                String tenlistcmt="PostID:"+so;
                List<CommentDTO>CmtinPost = (List<CommentDTO>)request.getAttribute(tenlistcmt);%>
                    <div class="comments">
                        <div class="comment-input">
                        <div><img src="img/avatar (2).png" width="40" class="rounded-image">
                            <form action="CommentOnPostController">
                                <input type="hidden" name="PostID" value="<%=post.getPostID()%>"/>
                        <input type="hidden" name="EventID" value="<%=event.getEventID() %>"/>
                                <div style="margin: -40px 0px 10px 60px;"> <input type="text" name="Comment" class="form-control"></div>
                            <div class="fonts"><button type="submit" style="margin-top: 8px;"><i
                                  class="fa fa-comment"></i></button>
                            </div>
                          </form>     
                          </div>
                        </div>
                      </div>
                        <% 
                        for (CommentDTO cmt:CmtinPost){
                            boolean checkcmt=false;
                            checkcmt =(cmt.getUserID()==user.getUserID())?true:false;
                            String tenlistrep="CmtID:"+String.valueOf(cmt.getCommentID());
                            List<ReplyDTO> repList= (List<ReplyDTO>) request.getAttribute(tenlistrep);
                            No++;
                        %>
                      <div ng-repeat="item in cont.Activity" class="JA_Activity" ng-init="reply = {toggle: false}">
                          <div class="d-flex flex-row mb-2"> <img src="img/avatar (1).png" width="40"
                              class="rounded-image">
                            <div class="d-flex flex-column ml-2"> <span class="name"><%=cmt.getName()%></span> <small
                                class="comment-text"><%=cmt.getComment() %></small>
                              <div class="d-flex flex-row align-items-center status"> <small><button type="submit"style="border: none;background-color: white;" onclick="myFunction<%=No%>()"><i class="fa fa-reply JA_ReplyIcon" 
                                      ng-click="reply.toggle = !reply.toggle"></i></button></small>
                                <%if (checkcmt) {%><small><button style="border: none;background-color: white;" type="submit"><a href="http://localhost:8080/EventManagerWebPage/DeleteCommentController?CmtID=<%=cmt.getCommentID()%>&EventID=<%=event.getEventID()%>"> <i class="fa fa-remove"></i></a></button></small>
                                <small><button style="border: none;background-color: white;" onclick="editCmt<%=No%>()" type="submit"><i class="fa fa-edit"></i></button></small>
                                <%}%>
                                <small>18 mins</small>
                              </div>
                            </div>
                          </div>
                        </div>
                                
                        <div class="ml-6" id="myDIV<%=No%>" style="display: none;margin-left: 50px">
                            
                          <div class="comment-input">
                            <div><img src="img/avatar (2).png" width="40" class="rounded-image">
                            <form action="ReplyOnCommentController">
                              <div style="margin: -40px 0px 10px 60px; "> <input type="text" name="Reply" class="form-control">
                                  <input type="hidden" type="text" name="CommentID" value="<%=cmt.getCommentID()%>"/>
                                  <input type="hidden" type="text" name="EventID" value="<%=event.getEventID()%>"/>
                                  
                                <div class="fonts"><button type="submit" style=" margin-top: 8px; border: none;background-color: white;"><i
                                      class="fa fa-comment"></i></button>
                                </div>  
                              </div>
                             </form>
                            </div>
                          </div>         
                        </div>
                        <div class="ml-6" id="myCmt<%=No%>" style="display: none;">
                            
                          <div class="comment-input">
                            <div><img src="img/avatar (2).png" width="40" class="rounded-image">
                            <form action="ChangeCommentController">
                              <div style="margin: -40px 0px 10px 60px; "> <input type="text" name="Comment" class="form-control">
                                  <input type="hidden" type="text" name="CmtID" value="<%=cmt.getCommentID()%>"/>
                                  <input type="hidden" type="text" name="EventID" value="<%=event.getEventID()%>"/>
                                  
                                <div class="fonts"><button type="submit" style=" margin-top: 8px; border: none;background-color: white;"><i
                                      class="fa fa-comment"></i></button>
                                </div>  
                              </div>
                             </form>
                            </div>
                          </div>         
                        </div>
                        <%for (ReplyDTO rep:repList){ 
                            NoRep++;
                        %>
                         <div class="d-flex flex-row mb-2" style="margin-left: 50px;"> <img src="img/avatar (2).png" width="40" class="rounded-image">
                        <div class="d-flex flex-column ml-3"> <span class="name"><%=rep.getName()%></span>
                          <small class="comment-text"><%=rep.getReply()%></small>
                          <div class="d-flex flex-row align-items-center status"> <small><button style="border: none;background-color: white;"  type="submit"><a href=""><i class="fa fa-reply"></i></a></button></small>
                            <%if (user.getUserID()==rep.getUserID()){ %>
                            <small><button style="border: none;background-color: white;"  type="submit"><a href="http://localhost:8080/EventManagerWebPage/DeleteReplyController?RepID=<%=rep.getReplyID()%>&EventID=<%=event.getEventID()%>"><i class="fa fa-remove"></i></a></button></small> 
                            <small><button style="border: none;background-color: white;"  type="submit" onclick="editRep<%=NoRep%>()"><i class="fa fa-edit"></i></button></small> 
                            <%}%>
                            <small>18 mins</small>
                          </div>
                        </div>
                      </div>
                            <div class="ml-6" id="myRep<%=NoRep%>" style="display: none;margin-left: 50px">
                          <div class="comment-input">
                            <div><img src="img/avatar (2).png" width="40" class="rounded-image">
                            <form action="ChangeReplyController">
                              <div style="margin: -40px 0px 10px 60px; "> <input type="text" name="Reply" class="form-control">
                                  <input type="hidden" type="text" name="RepID" value="<%=rep.getReplyID() %>"/>
                                  <input type="hidden" type="text" name="EventID" value="<%=event.getEventID()%>"/>
                                  
                                <div class="fonts"><button type="submit" style=" margin-top: 8px; border: none;background-color: white;"><i
                                      class="fa fa-reply"></i></button>
                                </div>  
                              </div>
                             </form>
                            </div>
                          </div>         
                        </div>

                        <% }%>
                      <% } %>
                   
                    </div>
                  </div>
                
              </div>
              <% }%>    
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <style type="text/css">
    body {
      padding: 25px 0px;
    }
    .comments button {
      border: none;
      background-color: white;
    }
     .edits button {
      border: none;
      background-color: white;
    }
    .card {
      position: relative;
      display: flex;
      flex-direction: column;
      min-width: 0;
      word-wrap: break-word;
      background-color: #fff;
      background-clip: border-box;
      border: 0 solid transparent;
      border-radius: .25rem;
      margin-bottom: 1.5rem;
      box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
      padding: 1.25rem;
    }

    .me-2 {
      margin-right: .5rem !important;
    }

    .avatar-wrapper {
      position: relative;
      height: 200px;
      width: 200px;
      margin: 0px auto;
      border-radius: 50%;
      overflow: hidden;
      box-shadow: 1px 1px 15px -5px black;
      transition: all 0.3s ease;
    }

    .avatar-wrapper:hover {
      transform: scale(1.05);
      cursor: pointer;
    }

    .avatar-wrapper:hover .profile-pic {
      opacity: 0.5;
    }

    .avatar-wrapper .profile-pic {
      height: 100%;
      width: 100%;
      transition: all 0.3s ease;
    }

    .avatar-wrapper .profile-pic:after {
      font-family: FontAwesome;
      content: "";
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      position: absolute;
      font-size: 190px;
      background: #ecf0f1;
      color: #34495e;
      text-align: center;
    }

    .avatar-wrapper .upload-button {
      position: absolute;
      top: 0;
      left: 0;
      height: 100%;
      width: 100%;
    }

    .avatar-wrapper .upload-button .fa-arrow-circle-up {
      position: absolute;
      font-size: 234px;
      top: -17px;
      left: 0;
      text-align: center;
      opacity: 0;
      transition: all 0.3s ease;
      color: #34495e;
    }

    .avatar-wrapper .upload-button:hover .fa-arrow-circle-up {
      opacity: 0.9;
    }
  </style>
  <!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'></script>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></script>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
  <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    $(document).ready(function () {

      var readURL = function (input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();

          reader.onload = function (e) {
            $('.profile-pic').attr('src', e.target.result);
          }

          reader.readAsDataURL(input.files[0]);
        }
      }

      $(".file-upload").on('change', function () {
        readURL(this);
      });

      $(".upload-button").on('click', function () {
        $(".file-upload").click();
      });
    });
        <%for (int i=1;i<=No;i++){%>
    function myFunction<%=i%>() {
        var x = document.getElementById("myDIV<%=i%>");
        if (x.style.display === "none") {
          x.style.display = "block";
        } else {
          x.style.display = "none";
        }
      }
      function editCmt<%=i%>(){
        var x = document.getElementById("myCmt<%=i%>");
        if (x.style.display === "none") {
          x.style.display = "block";
        } else {
          x.style.display = "none";
        }
      }
      <%}%>
      <%for (int i=1;i<=NoRep;i++){ %>
          function editRep<%=i%>(){
        var x = document.getElementById("myRep<%=i%>");
        if (x.style.display === "none") {
          x.style.display = "block";
        } else {
          x.style.display = "none";
        }
          }
      <%}%>
      function readURL(input) {
              if (input.files && input.files[0]) {
                  var reader = new FileReader();

                  reader.onload = function (e) {
                      $('#blah')
                          .attr('src', e.target.result);
                  };

                  reader.readAsDataURL(input.files[0]);
              }
          }
  </script>
</body>

</html>