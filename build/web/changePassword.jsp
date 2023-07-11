<%-- 
    Document   : changePassword
    Created on : Nov 21, 2021, 10:21:33 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>SETUP PASSWORD</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="css/style-verification.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
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
<style>
    .wrapper {
        position: relative;
    }

    input {
        padding-left: 48px;
    }

    .wrapper span {
        position: absolute;
        right: 20px;
        margin: 15px auto;
    }

    #message {
        display: none;
        color: #000;
        position: relative;
        font-size: 13px;
    }
    /* Add a green text color and a checkmark when the requirements are right */
    .valid {
        color: green;
    }

    .valid:before {
        position: relative;
        left: -35px;
        content: "✔";
    }

    /* Add a red text color and an "x" when the requirements are wrong */
    .invalid {
        color: red;
    }

    .invalid:before {
        position: relative;
        left: -35px;
        content: "✖";
    }
</style>

<body>


    <!-- partial:index.partial.html -->
    <!-- multistep form -->
    <%String email=request.getParameter("Email"); %>
   <form id="msform" action="ChangePasswordController" method="post">
        <fieldset>
            <h2 class="h2">Setup Password</h2>
            <h3 class="h3">Create a new password for</h3>
            <h3 class="h3"><%=email%></h3>
            <input name="Email" type="hidden" value="<%=email%>"/>
            <div class="wrapper">        
                <input id="pass_log_id" type="password" name="Password" placeholder="Password"
                    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,}" required>
                <span toggle="#password-field" class="fa fa-fw fa-eye field_icon toggle-password"></span>
            </div>
            <div id="message">
                <p id="length" class="invalid">Minimum <b>3 characters and have at least 1 uppercase,1 lowercase, 1 number</b></p>
            </div>
            <input type="button" onclick="location.href='index.html';" name="go back" class="previous  "
                value="Go back" />
            <input type="submit" name="Submit"  class="next action-button">
            <br />
            <span style="color: red;">ERROR !!!</span>
        </fieldset>
    </form>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"
        type="text/javascript"></script>
    <script>
        function myFunction() {
            alert("Successful.");
            window.location = "index.html";
        }
        $(document).on('click', '.toggle-password', function () {

            $(this).toggleClass("fa-eye fa-eye-slash");

            var input = $("#pass_log_id");
            input.attr('type') === 'password' ? input.attr('type', 'text') : input.attr('type', 'password')
        });
        var myInput = document.getElementById("pass_log_id");
        var length = document.getElementById("length");

        // When the user clicks on the password field, show the message box
        myInput.onfocus = function () {
            document.getElementById("message").style.display = "block";
        }

        // When the user clicks outside of the password field, hide the message box
        myInput.onblur = function () {
            document.getElementById("message").style.display = "none";
        }

        // When the user starts to type something inside the password field
        myInput.onkeyup = function () {
            if (myInput.value.length >= 3) {
                length.classList.remove("invalid");
                length.classList.add("valid");
            } else {
                length.classList.remove("valid");
                length.classList.add("invalid");
            }
        }
    </script>
</body>

</html>