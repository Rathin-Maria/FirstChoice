<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
input[type=text]
 {
  width: 100%;
  padding: 10px;
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
  border: 1px solid #5eff9f;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 4px 8px;
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
<!-- we need to make this form a spring form to do this we will add the tag lib of my spring form -->
<form:form action="addcategory" method="post" modelAttribute="categoryobject">
  <div class="container">
    <p style="font-size:170%;font-family:algerian;text-align:center;"><ins>Categories</ins></p>
	<p style="font-size:130%;">Please Enter The Category Details.</p>
    <hr>
    <label for="category_Name"><b  style="font-size:140%;">Category Name</b></label>
    <form:input type="text" placeholder="Enter The Category Name" name="category_Name" path="category_Name"/>
	

    <button type="submit" class="registerbtn" style="font-size:120%;">Submit</button>
	<br>
	<br>
	<hr>
</div>
</form:form>
</div>
</body>
</html>
