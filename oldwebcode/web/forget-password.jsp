<%-- 
    Document   : forget-password
    Created on : Nov 1, 2021, 10:19:39 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>OTP VERIFICATION</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/style-verification.css">

</head>

<body>


  <!-- partial:index.partial.html -->
  <!-- multistep form -->
  <form id="msform" action="ForgetPasswordController">
    <fieldset>
      <h2 class="h2">We sent your password</h2>
      <h3 class="h3">Enter your email below</h3>
      <input type="text" name="Email" placeholder="Enter your email" />
      <input type="button" onclick="location.href='Login.jsp';" name="go back" class="previous  " value="Go back" />
      <input type="submit" name="Submit" class="next action-button" value="Send" />
      <br/>
      <%String error= (String) request.getAttribute("Error"); 
      if (error==null) error="";%>
      <span style="color: red;"><%=error%></span>
    </fieldset>
    
  </form>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"
    type="text/javascript"></script>
    <%String success=(String)request.getAttribute("Success");%>
    <script>
      window.onload=myFunction();
    function myFunction() {
      <%if (success!=null){
          request.removeAttribute("Success");
      %>
      alert("Reset password successful!");
      window.location = "Login.jsp";
      <% }%>
    }
  </script>
</body>

</html>