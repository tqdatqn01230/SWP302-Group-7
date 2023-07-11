<%@page import="models.user.RegisterError" %>
<%@page import="models.user.UserDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>MEETUP - EVENTS SOLUTION</title>
   <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700|Raleway:300,600" rel="stylesheet">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
   <link rel="stylesheet" href="css/style.css">
</head>

<body>
<!-- partial:index.partial.html -->
<div class="container">
   <section id="formHolder">

      <div class="row">

         <!-- Brand Box -->
         <div class="col-sm-6 brand">
            <a href="#" class="logo">MEETUP <span>.</span></a>

            <div class="heading">
               <h2>MEETUP</h2>
               <p>Your Right Choice</p>
            </div>

            <div class="success-msg">
               <p>Great! You are one of our members now</p>
               <a href="#" class="profile">Your Profile</a>
            </div>
         </div>


         <!-- Form Box -->
         <div class="col-sm-6 form">

            <!-- Login Form -->
            <div class="login form-peice switched">
               <form class="signup-form" action="RegisterController" method="get">

                  <div class="form-group">
                     <label for="name">Full Name</label>
                     <input type="text" name="FullName" id="name" class="name">
                     
                     <span class="error"></span>
                  </div>
                  <div class="form-group">
                     <label for="email">Email Adderss</label>
                     <input type="text" name="Email" id="email" class="email">
                     <input type="hidden" value="" id="EmailError">
                     <span class="error"></span>                  
                  </div>
                  <div class="form-group">
                     <label for="name">User Name</label>
                     <input type="text" name="UserName" id="name" class="name">
                     <input type="hidden" id="UserNameError" value=""/>
                     <span class="error"></span>
                  </div>

                  <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" name="Password" id="password" class="pass">
                     <span class="error"></span>
                  </div>

                  <div class="form-group">
                     <label for="passwordCon">Confirm Password</label>
                     <input type="password" name="Confirm" id="passwordCon" class="passConfirm">
                     <span class="error"></span>
                  </div>
                  <div class="CTA">
                     <button type="submit">Signup</button>
                     <a href="#" class="switch">I have an account</a>
                  </div>
               </form>
            </div>
               <% String error =(String)session.getAttribute("LOGIN_ERROR");
               if (error==null) error="";%>
               <div class="signup form-peice">
                  <form class="login-form" action="LoginController" method="get">
                     <div class="form-group">
                        <label for="loginemail">User Name</label>
                        <input type="text" name="UserName" id="loginemail" required>
                     </div>
                     <div class="form-group">
                        <label for="loginPassword">Password</label>
                        <input type="password" name="Password" id="loginPassword" required>
                     </div>
                      <span style="color: red;"><%=error%></span>
                     <div class="CTA">
                        <button type="submit" value="Login">Login</button>
                        <a href="forget-password.jsp" class="forget">Forget Password</a>
                        <a href="" class="switch">I'm New</a>
                     </div>
                     <div class="or-container">
                        <div class="line-separator"></div>
                        <div class="or-label">or</div>
                        <div class="line-separator"></div>
                     </div>
                     <div class="social">
                        <button type="button" class="btn btn-danger"><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/EventManagerWebPage/LoginByMailController&response_type=code&client_id=320372249105-n9lqj4retbe65vf3coa4go6q6e6jca0i.apps.googleusercontent.com&approval_prompt=force">GOOGLE</a></button>
                  </form>
               </div>
            </div>

   </section>
                  <style>
                      .form form .CTA a.forget {
  font-size: 13px;
  font-weight: 400;
  font-family: "Montserrat", sans-serif;
  color: #bbbbbb;
  text-decoration: none;
  transition: all 0.3s;
  
}
.form form .CTA a.forget:hover {
  color: #f95959;
}
                  </style>

   <footer>

   </footer>

</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src="js/script.js"></script>

</body>

</html>