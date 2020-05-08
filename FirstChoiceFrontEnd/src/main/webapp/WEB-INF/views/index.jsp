<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Index Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>

<jsp:include page="navbar.jsp"></jsp:include>

<div style="min-heght:400px;">

<c:if test="${indexpage}">
    <jsp:include page="slider.jsp"></jsp:include>
</c:if>
<c:if test="${aboutuspage}">
    <jsp:include page="aboutus.jsp"></jsp:include>
</c:if>
<c:if test="${contactuspage}">
    <jsp:include page="contactus.jsp"></jsp:include>
</c:if>
<c:if test="${loginpage}">
    <jsp:include page="login.jsp"></jsp:include>
</c:if>
<c:if test="${registerpage}">
   <jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${categorypage}">
   <jsp:include page="category.jsp"></jsp:include>
</c:if>
<c:if test="${productpage}">
    <jsp:include page="product.jsp"></jsp:include>
</c:if>
<c:if test="${cust_productpage}">
    <jsp:include page="allproducts.jsp"></jsp:include>
</c:if>
<c:if test="${productdetails_page}">
    <jsp:include page="productdetails.jsp"></jsp:include>
</c:if>

</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>