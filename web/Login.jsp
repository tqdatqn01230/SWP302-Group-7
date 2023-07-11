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

<body>
   <!-- partial:index.partial.html -->
   <div class="container">
      <section id="formHolder">
         <div class="row">
             <button style="margin-left: -100px;width: 100px;border: none;
            background-color: white;"><a href="http://localhost:8080/EventManagerWebPage/ViewEventsController" 
                  style="text-decoration: none;
                  color: black;color:grey;">&laquo; Previous</a></button>
            <!-- Brand Box -->
            <div class="col-sm-6 brand">
               <a href="#" class="logo">MEETUP <span>.</span></a>
               <div class="heading">
                  <h2>MEETUP</h2>
                  <p>Your Right Choice</p>
               </div>
            </div>
            <!-- Form Box -->
            <%RegisterError error1 = (RegisterError)request.getAttribute("Error");
            if (error1==null) 
                error1 =new RegisterError(); %>
            <div class="col-sm-6 form">
               <!-- Login Form -->
               <div class="login form-peice switched">
               <form  action="RegisterController" method="get">

                  <div class="form-group">
                     <label for="name">Full Name</label>
                     <input type="text" name="FullName" id="name" class="name">           
                     <p class="error"><%=error1.fullname%></p>
                  </div>
                  <div class="form-group">
                     <label for="email">Email Adderss</label>
                     <input type="text" name="Email" id="email" class="email">
                     <input type="hidden" value="" id="EmailError"> 
                     <p><%=error1.gmail%></p>
                  </div>
                  <div class="form-group">
                     <label for="name">User Name</label>
                     <input type="text" name="UserName" id="name" class="name">
                     <input type="hidden" id="UserNameError" value=""/>
                     <p class="error"><%=error1.username%></p>
                  </div>

                  <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" name="Password" id="password" class="pass">
                     <p class="error"><%=error1.password%></p>
                  </div>

                  <div class="form-group">
                     <label for="passwordCon">Confirm Password</label>
                     <input type="password" name="Confirm" id="passwordCon" class="passConfirm">
                     <p class="error"><%=error1.confirmpassword%></p>
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
            </div>
      </section>
      <footer>
      </footer>
   </div>
   <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
   <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
   <script src="js/script.js"></script>

</body>

</html>