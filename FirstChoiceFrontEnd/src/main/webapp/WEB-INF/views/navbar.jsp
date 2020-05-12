<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
  
  .theader {
   position: fixed;
   left: 0;
   top:0;
   width: 100%;
   height:4%;
   background-color: rgb(63,113,69);
   color: white;
   text-align: center;
   }
   
  table
  {
  width: 100%;
  }
  th, td 
  {
  padding: 0px;
  }
 a{
 font-family:calibri;
 color:white;
 font-size:17px;
 }
  
  
  </style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<div class="theader">
		<table>
			<tr>
			    <th><a href="${cr }/home"target="_self">Home</a></th>
				<th><a href="${cr }/aboutus" target="_self">About Us</a></th>
				<th><a href="${cr }/contactus" target="_self">Contact Us</a></th>
				<th><a href="${cr }/register"  target="_self" >Register</a></th>
				<th><a href="login" target="_self">Login</a></th>
				<th><a href="${cr }/allproducts" target="_self">All Products</a></th>
				<th><a href="${cr }/admin/category" target="_self">Manage Category</a></th>
				<th><a href="${cr }/admin/products" target="_self">Manage Products</a></th>
			</tr>
		</table>
	</div>

	<p style="margin-top:3px;white-space:nowrap;margin-bottom:0px;width:100%;font-family:algerian;font-size:75px;color:green;text-align:center;">
    <img src="img/logo.png" alt="LOGO" style="float:center;width:70px;height:65px;"><i>First Choice Retails</i></p>
	

</body>
</html>