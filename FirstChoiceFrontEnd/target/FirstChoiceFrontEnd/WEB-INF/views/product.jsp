<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
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
height: 470px;
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
input[type=text], input[type=number],textarea,select
 {
  width: 100%;
  padding: 2px;
  margin: 2px 0 8px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
  font-size: 90%;
}

input[type=text]:focus, input[type=number]:focus, textarea:focus, select:focus {
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
    
				<table class="tabledisplay">
					<thead class="dark-row">
						<tr class="movie-table-head">
						  <th class="tabledisplay">Product Image</th>
							<th class="tabledisplay">Product Name</th>
							<th class="tabledisplay">Product Description</th>
							<th class="tabledisplay">Stock</th>
							<th class="tabledisplay">Price</th>
							<th class="tabledisplay">Category</th>
							<th class="tabledisplay" style="width:150px">Edit/Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productlist}" var="p">
							<tr>
							    <td class="tabledisplay"><img src="pimg/${p.product_Id}.jpeg" height="50px" ></td>
								<td class="tabledisplay">${p.product_Name}</td>
	                            <td class="tabledisplay">${p. product_Description}</td>
	                            <td class="tabledisplay">${p.product_Stock}</td>
	                            <td class="tabledisplay">${p.product_Price}</td>
								<td class="tabledisplay">${p.product_Category.category_Name}</td>
								                <td  class="tabledisplay" class="text-center"><a class='btn btn-info btn-xs' href="getproductstoedit?productid=${p.product_Id}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="deleteproducts?productid=${p.product_Id}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
	
		</div>



 <div class="container">
<c:if test="${edit}">
         <c:set var="url"  value="updateproducts"/>
  </c:if>
 <c:if test="${!edit}">
         <c:set var="url"  value="addproducts"/>
  </c:if>
  
<form:form action="${url} " method="post" modelAttribute="productobject" enctype="multipart/form-data">
 
  
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
	
      <p style="font-size:110%;font-family:algerian;text-align:center;"><ins>Products</ins></p>
    <c:if test="${edit}">
		       <form:hidden  id="product_id" placeholder="Product Id" name="product_id" path="product_Id"/>       
	</c:if>
	
    <label for="product_name"><b  style="font-size:100%;">Product Name</b></label>
    <form:input type="text" placeholder="Enter Your Name"  id="product_name"  name="product_name"  path="product_Name"/>
     <form:errors path="product_Name" cssStyle="color:Red"></form:errors><br>
	
	
    <label for="product_description"><b  style="font-size:100%;">Description</b></label>
     <form:textarea style="font-size:90%;height:50px;" id="product_description" name="product_description"   placeholder="Write Something..." path="product_Description"/>
     <form:errors path="product_Description" cssStyle="color:Red"></form:errors><br>
     
	<label for="product_stock"><b  style="font-size:100%;">Stock</b></label>
	<form:input type="number" placeholder="Enter the Stock"  name="product_stock"  path="product_Stock"/>
	<form:errors path="product_Stock" cssStyle="color:Red"></form:errors><br>
	
    <label for="product_price"><b style="font-size:100%;">Price</b></label>
    <form:input type="number" step="any"  placeholder="Enter Price"  id="product_price" name="product_price"  path="product_Price"/>
    <form:errors path="product_Price" cssStyle="color:Red"></form:errors><br>
      
      <label for="category_name"><b  style="font-size:100%;">Category  Name</b></label><br>
    <form:select   id="category_name"  name="category_name" path="product_Category.category_Id">
     <c:forEach items="${catlist}" var="c">
    <option value="${c.category_Id}">${c.category_Name}</option>
     </c:forEach>
    </form:select>
    
       <form:input  type="file" path="product_Image"/>
       
       <button type="submit"  class="registerbtn" style="font-size:100%;">Submit</button>

</form:form>
</div>

</body>
</html>