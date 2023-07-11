<%-- 
    Document   : ConfirmMailRegister
    Created on : Sep 20, 2021, 5:48:56 PM
    Author     : Dell
--%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>OTP VERIFICATION</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="css/style-verification.css">

</head>
<body>


<form id="msform" action="ConfirmMailRegisterController">
      <fieldset>
        <h2 class="h2">We sent your code</h2>
        <h3 class="h3">Enter the confirmation code below</h3>
        <%String error=(String)session.getAttribute("WRONG_CODE"); 
        if (error==null) error="";%>
        <input type="text" name="Code" placeholder="Enter confirmation code" />
        <input type="submit" name="Action" class="previous" value="Back" />
        <input type="submit" name="Action" class="next action-button" onclick="myFunction()" value="Confirm" />
        <input type="submit" name="Action" class="next action-button" value="Send Again" /><br/>
         <span style="color: red;" id="message"><%=error%></span>

      </fieldset>
   <script>
    function myFunction() {
      alert("Success! You have been signed in successfully!");
      window.location = "index.html";
    }
  </script>
</form>
