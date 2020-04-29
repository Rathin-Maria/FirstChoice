<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
  font-family: Calibri;
  background-color: white;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password],input[type=email],input[type=tel] 
 {
  width: 100%;
  padding: 5px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
  font-size: 100%;
}

input[type=text]:focus, input[type=password]:focus,input[type=email]:focus,input[type=tel]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 6px 12px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<div style="width:50%;height:50%;margin-left:25%;">

<c:if test="${info}">
  <div class="alert alert-success" role="alert">
  ${message}</div>
</c:if>

<form:form action="registered" method="post" modelAttribute="customerobject">
  <div class="container">
    <p style="font-size:170%;font-family:algerian;text-align:center;"><ins>Register</ins></p>
    <label for="cust_name"><b  style="font-size:130%;">Name</b></label>
    <form:input type="text" placeholder="Enter Your Name"  id="cust_name"  name="cust_name"  path="customer_Name"/>
	
	
    <label for="cust_email"><b  style="font-size:130%;">Email Id</b></label>
    <form:input type="email" placeholder="Enter Email"  id="cust_email" name="cust_email"  path="customer_Email"/>
      
	<label for="cust_no"><b  style="font-size:130%;">Contact Number</b></label>
	<form:input type="tel" placeholder="Enter Your Contact Number" pattern="[0-9]{10}"  name="cust_no"  path="customer_PhoneNo"/>
	
    <label for="cust_password"><b style="font-size:130%;">Password</b></label>
    <form:input type="password" placeholder="Enter Password"  id="cust_password" name="cust_password"  path="customer_Password"/>

    <button type="submit"  class="registerbtn" style="font-size:130%;">Register</button>
  
  <div class="container signin">
    <p style="font-size:110%;">Already have an account? <a style="font-size:110%;color:blue;" href="login">Sign in</a>.</p>
  </div>
</div>
</form:form>
</div>
</body>
</html>
