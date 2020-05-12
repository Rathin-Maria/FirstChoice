<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
   <c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Category</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
  font-family: Calibri;
  background-color: white;
 margin-bottom: 3%;
}

* {
  box-sizing: border-box;
}

div.box
{
  width: 64%;
  height: 470px;
 float: right;
 margin-right: 2%;
  overflow: auto;
 
}

/* Add padding to containers */
.container {
  padding: 10px;
 background-color: white;
width:30%;
margin-left: 2%;
overflow: auto;
height: 200px;
border: 2px solid green;
}

.tabledisplay
{
border: 2px solid green;
border-collapse: collapse;
text-align: center;
padding: 5px;
}
/* Full-width input fields */
input[type=text], textarea,select
 {
  width: 100%;
  padding: 2px;
  margin: 2px 0 8px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
  font-size: 90%;
}

input[type=text]:focus, textarea:focus, select:focus {
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
  padding: 3px 6px;
  margin: 2px 0;
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

  <div class="box">
				<table  class="tabledisplay">
					<thead class="dark-row">
						<tr class="movie-table-head">
							<th  class="tabledisplay">Category Name</th>
							<th  class="tabledisplay">Edit/Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${catlist}" var="c">
							<tr>
								
								<td  class="tabledisplay">${c.category_Name}</td>
								                <td   class="tabledisplay" class="text-center"><a class='btn btn-info btn-xs' href="${cr }/admin/getcategorytoedit?catname=${c.category_Name}"><span class="glyphicon glyphicon-edit"></span> Edit</a> 
								                <a href="${cr }/admin/deletecategory?catname=${c.category_Name}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
	
		</div>
		
		
 <div class="container">
 
<c:if test="${success}">
		<div class="alert alert-success">
			<strong>Success!</strong>${message}
		</div>
	</c:if>
	<c:if test="${error1}">
		<div class="alert alert-danger">
			<strong>Error!</strong>${message}
		</div>
	</c:if>
	
	<c:if test="${error2}">
		<div class="alert alert-warning">
			<strong>Warning!</strong>${message}
		</div>
	</c:if>
<!-- we need to make this form a spring form to do this we will add the tag lib of my spring form -->
<c:if test="${edit}">
         <c:set var="url"  value="${cr }/admin/updatecategory"/>
  </c:if>
 <c:if test="${!edit}">
         <c:set var="url"  value="${cr }/admin/addcategory"/>
  </c:if>
<form:form action="${url} " method="post" modelAttribute="categoryobject">
 
    <p style="font-size:110%;font-family:algerian;text-align:center;"><ins>Categories</ins></p>
    <c:if test="${edit}">
		       <form:hidden  id="category_id" placeholder="Category Id" name="category_id" path="category_Id"/>       
	</c:if>
    
    <label for="category_name"><b  style="font-size:100%;">Category Name</b></label>
    <form:input type="text" id="category_name" placeholder="Enter The Category Name" name="category_name" path="category_Name"/>
   <form:errors path="category_Name" cssStyle="color:Red"></form:errors>
    <button type="submit" class="registerbtn" style="font-size:100%;">Submit</button>
 

</form:form>
</div>
</body>
</html>
