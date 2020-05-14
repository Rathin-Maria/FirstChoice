<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html> 
<head>
<title>Login Page</title>
<style> 
    /*set border to the form*/ 
      
    form { 
          border: 0px; 
          } 
    /*assign full width inputs*/ 
      
    input[type=text], 
    input[type=password] { 
        width: 100%; 
        font-size:100%;
        padding: 3px 6px; 
        margin: 8px 0; 
        display: inline-block; 
        border: 1px solid #ccc; 
        box-sizing: border-box; 
    } 
    /*set a style for the buttons*/ 
      
    button { 
        background-color: #4CAF50; 
        color: white; 
        padding: 3px 6px; 
        margin: 8px 0; 
        border: none; 
        cursor: pointer; 
        width: 100%; 
    } 
    /* set a hover effect for the button*/ 
      
    button:hover { 
        opacity: 0.8; 
    } 
    /*set extra style for the cancel button*/ 
      
    .cancelbtn { 
        width: auto; 
        padding: 3px 6px; 
        background-color: #f44336; 
    } 
	/*set extra style for the register button*/ 
      
    .registerbtn { 
        width: auto; 
        padding: 3px 6px; 
        background-color:#4CAF55; 
    } 
    /*centre the display image inside the container*/ 
      
    .imgcontainer { 
        text-align: center; 
        margin: 24px 0 12px 0; 
    } 
    /*set image properties*/ 
      
    img.avatar { 
        width: 40%; 
        border-radius: 50%; 
    } 
    /*set padding to the container*/ 
      
    .container { 
        padding: 6px; 
    } 
    /*set the forgot password text*/ 
      
    span.psw { 
        float: right; 
        padding-top: 6px; 
    } 
    /*set styles for span and cancel button on small screens*/ 
      
    @media screen and (max-width: 300px) { 
        span.psw { 
            display: block; 
            float: none; 
        } 
        .cancelbtn { 
            width: 100%; 
        } 
    } 
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
</head>
  
<body style="font-family:calibri;"> 
 <div style="width:30%;height:30%;margin-left:35%;margin-bottom:7%;"> 
   <p style="font-size:170%;font-family:algerian;text-align:center;"><ins>Login Details</ins></p> 
    <!--Step 1 : Adding HTML-->
    <form action="perform_login" method="post"> 
    <c:if test="${success}">
		<div class="alert alert-success">
			<strong>${message}</strong>
		</div>
	</c:if>
	<c:if test="${error1}">
		<div class="alert alert-danger">
			<strong>${message}</strong>
		</div>
	</c:if>
	
	<c:if test="${error2}">
		<div class="alert alert-warning">
			<strong>${message}</strong>
		</div>
	</c:if>
        <div class="imgcontainer"> 
            <img style="width:200px;height:190px;" src= "img/User.jpg" 
                 alt="Avatar" class="avatar"> 
        </div> 
  
        <div class="container"> 
            <label style="font-size:120%;"><b>Username</b></label> 
            <input type="text" id="password"  placeholder="Enter Username" name="user_name" required> 
  
            <label  style="font-size:120%;"><b>Password</b></label> 
            <input type="password"  id="user_password" placeholder="Enter Password" name="user_password" required> 
  
            <button type="submit"  style="font-size:120%;">Login</button> 
                   </div> 
  
        <div class="container" style="background-color:#f1f1f1"> 
            <a  style="float:left;font-size:120%;" href="home"><button type="button" class="cancelbtn">Cancel</button> </a>
           <a  style="float:right;font-size:120%;" href="register"><button type="button" class="registerbtn">Register</button></a>
        </div> 
    </form> 
  </div>
</body> 
  
</html> 