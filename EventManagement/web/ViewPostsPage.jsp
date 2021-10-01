<%-- 
    Document   : ViewPostsPage
    Created on : Sep 23, 2021, 4:51:31 PM
    Author     : Dell
--%>

<%@page import="models.replys.ReplyDTO"%>
<%@page import="models.Comments.CommentDTO"%>
<%@page import="models.posts.PostDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.events.EventsDTO"%>
<%@page import="models.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>POSTS</title>
    </head>
    <body>
        <%UserDTO user= (UserDTO)session.getAttribute("USER") ;
         String fullname;
        if (user!=null){
            fullname=user.getFullName();
        }else fullname="";
        EventsDTO event=(EventsDTO)request.getAttribute("Event");
        boolean check=false;
        if (event.getUserID()==user.getUserID()) check=true;
        %>
        <h1>Welcome <%=fullname %></h1>
        <form action="LogoutController">
            <input type="submit" value="Logout"/>
        </form>
        <form action='ViewEventsController'>
            <input type='submit' value='Back to View Events'>
        </form>
        <div><h2>Event post by <%=event.getUserID() %></h2></div>
        <div><h3><%=event.getEventContent() %> </h3> </div>
        <%if (check){%>
        <form action='PostController'>
            <input type='text' name='PostContent' Placeholder='Enter Post Content Here'/>
            <input type='hidden' name='EventID' value='<%=event.getEventID() %>'/>
            <input type='submit' value='Add post'/>
        </form>
        <% }%>
       <%List<PostDTO> list_post=(List<PostDTO>)request.getAttribute("List_Posts");
           for (PostDTO post:list_post){
               String ListNameImage="ImagesID:"+String.valueOf(post.getPostID());
               List<String> ListImage=(List<String>) request.getAttribute(ListNameImage);
       %>
            <div><h2><%=post.getPostContent() %> </h2> </div>
            <form action="ChangeNDeletePostMainController">
                <input type="text" name="Content"/>
                <input type='hidden' name='EventID' value='<%=event.getEventID()%>'/>
                <input type='hidden' name="PostID" value="<%=post.getPostID()%>"/>
                <input type="submit" name="Action" value="Change Post"/>
                <input type="submit" name="Action" value="Delete Post"/>
            </form>
            <%for (String image:ListImage){%>
        
            <div><img src="<%=image%>" width="300" height="400"> </div>    
            <% }%>
            <%if (check){ %>
            <form action='AddImageOnPostController' method='post' enctype="multipart/form-data">
                <input type='hidden' name='EventID' value='<%=event.getEventID()%>'/>
                <input type='hidden' name="PostID" value="<%=post.getPostID()%>"/>
                <img id="blah" alt="" width="300" height="300" />
                Select file to upload: <input id="image" type="file" name="file" size="60" accept="image/*" 
                    onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])" /> <br/> <br /> 
                <input type="submit" value="Upload" />
            </form>
            <% }%>
            <%  String so=String.valueOf(post.getPostID());
                String tenlistcmt="PostID:"+so;
                List<CommentDTO>CmtinPost = (List<CommentDTO>)request.getAttribute(tenlistcmt);%>
                <form action="CommentOnPostController">
                    <input type="hidden" name="PostID" value="<%=post.getPostID()%>"/>
                    <input type="hidden" name="EventID" value="<%=event.getEventID() %>"/>
                    <input type="text" name="Comment" placeholder="Leave comment on this post"/><br/> 
                    <input type='submit' name="Action" value="Comment"/>
                </form>
              <%for (CommentDTO cmt:CmtinPost){
                  boolean checkcmt=false;
                  checkcmt =(cmt.getUserID()==user.getUserID())?true:false;
                %>
                <div><h3><%=cmt.getComment() %> </h3> </div>
                <%if (checkcmt){%>
                <form action="ChangeNDeletePostMainController">
                    <input type="text" name="Comment"/>
                    <input type='hidden' name='EventID' value='<%=event.getEventID()%>'/>
                    <input type="hidden" name="CmtID" value="<%=cmt.getCommentID()%>"/>
                    <input type="submit" name="Action" value="Change Comment"/>
                    <input type="submit" name="Action" value="Delete Comment" />
                </form>
                <% }%>
                <%  String cmtID=String.valueOf(cmt.getCommentID()) ;
                    String tenlistRep="CmtID:"+cmtID;
                    List<ReplyDTO> RepinCmt= (List<ReplyDTO>) request.getAttribute(tenlistRep);
                    if (CmtinPost.size()!=0){%>
                    <form action="ReplyOnCommentController">
                        <input type="hidden" name="CommentID" value="<%=cmt.getCommentID() %>"/>
                        <input type="hidden" name="EventID" value="<%=event.getEventID() %>"/>
                        <input type="text" name="Reply" placeholder="Reply this comment"/>
                        <input type="submit" name="Action" value="Reply"/>
                    </form>
                    <% }
                    for (ReplyDTO rep:RepinCmt){
                        boolean checkrep=false;
                        checkrep =(rep.getUserID()==user.getUserID())?true:false;
                    %>
                    <div><p><%=rep.getReply() %> </p> </div>
                    <%if (checkrep){%>
                <form action="ChangeNDeletePostMainController">
                    <input type="text" name="Reply"/>
                    <input type='hidden' name='EventID' value='<%=event.getEventID()%>'/>
                    <input type="hidden" name="RepID" value="<%=rep.getReplyID()%>"/>
                    <input type="submit" name="Action" value="Change Reply"/>
                    <input type="submit" name="Action" value="Delete Reply" />
                </form>
                <%} }%>
       <% }} %>
    </body>
</html>
