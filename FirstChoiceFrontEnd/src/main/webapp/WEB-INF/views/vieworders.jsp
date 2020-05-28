<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
body
 {
 
	font-family: Calibri;
	background-color: white;
	margin-bottom: 3%;
}

input[type=text], input[type=number], textarea, select {
	width: 100%;
	padding: 2px;
	margin: 2px 0 8px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	font-size: 90%;
}

input[type=text]:focus, input[type=number]:focus, textarea:focus, select:focus
	{
	background-color: #ddd;
	outline: none;
}

.tabledisplay {
     font-family:calibri;
     font-size:25px;
	border-collapse: collapse;
	text-align: center;
	padding: 5px;
}

div.box{
  padding: 15px;
  width: 100%;
  border: 2px solid green;
  border-radius:5px;
  margin-top: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Address</title>
</head>
<body>
<div class="container">
<p
				style="font-size: 170%; font-family: algerian; text-align: center;">
				<ins>My Orders</ins>
			</p>
			
			
<c:if test="${empty orderPerId}">
<div>No Active Orders</div>
</c:if>

<c:if test="${!empty orderPerId}">

<c:forEach items="${orderPerId}" var="outerlist">
<div class="box">

<c:forEach items="${outerlist}" var="o" varStatus="loop">
<c:if test="${loop.first}">
          <h2>${o.order_Id}</h2>
          <h3>Order Placed on: ${o.order_Date}</h3>
          <h3>Place of Delivery : ${o.customer_Address.address_State}-${o.customer_Address.address_Pincode}</h3>
          <hr>
 </c:if>

<table class="tabledisplay">
			<thead>
				<tr>
					<td style="width:130px;" class="tabledisplay"><img src="${cr }/pimg/${o.product_Details.product_Id}.jpeg"  style="margin:10px;width:80px;height:80px;"></td>
					<td style="width:130px;" class="tabledisplay" >${o.product_Details.product_Name}</td>
					<td style="width:130px;" class="tabledisplay">&#x20B9 ${o.product_Details.product_Price}</td>
					<td style="width:130px;" class="tabledisplay">Quantity:&nbsp ${o.product_Quantity}</td>
				</tr>
			</thead>
</table>

</c:forEach>

<c:forEach items="${outerlist}" var="o" varStatus="loop">
<c:if test="${loop.first}">
<hr>
          <h1 style="text-align: right;">Total:&#x20B9 ${o.order_Total}/- &nbsp</h1>
 </c:if>
</c:forEach>

</div>
</c:forEach>

</c:if>
</div>
</body>
</html>