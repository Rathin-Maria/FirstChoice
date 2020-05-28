<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
	font-family: Calibri;
	background-color: white;
	margin-bottom: 3%;
}


* {
	box-sizing: border-box;
}

input::-webkit-outer-spin-button,input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type=number] {
  -moz-appearance: textfield;
}

.container {
	padding: 10px;
	background-color: white;
	width: 30%;
	float:right;
	margin-right: 2%;

	height: 470px;
	border: 2px solid green;
}

div.box {
	width: 64%;
	height: 470px;
	margin-left: 2%;	
	overflow: auto;
}

.tabledisplay {
	border: 2px solid green;
	border-collapse: collapse;
	text-align: center;
	padding: 5px;
}

.tableprice {
	border-collapse: collapse;
	text-align: left;
	padding:5px;
}

</style>
</head>
<body>
<c:if test="${empty cartinfo}">
<div class="jumbotron">no items</div>
</c:if>
<c:if test="${not empty cartinfo}">
<div class="container">
		<p
				style="font-size: 170%; font-family: algerian; text-align: center;">
				<ins>Price Details</ins>
			</p>
			<hr style="border:double;">
			<table class="tableprice">
			<tr>
			<th><h2><pre>  Price</pre></h2></th>
			<td><pre>  </pre></td>
			<td><h4>:  &#x20B9 ${sessionScope.Price}</h4></td>
			</tr>
			<tr>
			<th><h2><pre>  Shipping Fee</pre></h2></th>
			<td><pre>  </pre></td>
			<td>
			<c:if test="${sessionScope.ShippingFee > 0}">
			<h4 style="color:red;">:  &#x20B9 ${sessionScope.ShippingFee}</h4>
			</c:if>
			<c:if test="${sessionScope.ShippingFee == 0}">
			<h4 style="color:green;">: FREE</h4>
			</c:if>
			</td>
			</tr>
			</table>
			<hr style="border:1px dotted;">
			<table class="tableprice">
			<tr>
			<th><h2><pre>  Total</pre></h2></th>
			<td><pre>                 </pre></td>
			<td><h4>:  &#x20B9 ${sessionScope.Total}</h4></td>
			</tr>
			</table>
			<hr style="border:1px dotted;">
			<c:if test="${sessionScope.ShippingFee > 0}">
			<h5 style="color:red;">Purchase  &#x20B9  <fmt:formatNumber type="number" maxFractionDigits="2" value="${1000 - sessionScope.Total}"/> more to avail Free Delivery...</h5>
			</c:if>
			<c:if test="${sessionScope.ShippingFee == 0}">
			<h5 style="color:green;">You save &#x20B9 50 by availing Free Delivery charge...</h5>
			</c:if>
			<hr style="border:double;">
			<div class="row">
			                   <div class="col-6">
									<a href="${cr }/productdetails?productid=${p.product_Id}" style="float: left;width:190px;" class="btn btn-warning"><i class="fa fa-arrow-left" aria-hidden="true"></i>  Save for Later</a>
								</div>
								<div class="col-6">
									<a href="${cr }/addtocart?productid=${p.product_Id}" style="float: right;width:190px;" class="btn btn-success">Place Order <i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
								</div>								
		</div>
		<hr style="border:double;">
		<h5 style="text-align: center;font-size: 110%;color:gray;">*First Choice is Always the People Choice*</h5>
	</div>

<div class="box">
	
		<table class="tabledisplay">
			<thead class="dark-row">
				<tr class="movie-table-head">
					<th class="tabledisplay">Product Image</th>
					<th class="tabledisplay">Product Name</th>
					<th class="tabledisplay">Price</th>
					<th class="tabledisplay">Quantity</th>
					<th  style="width:130px;" class="tabledisplay">Sub-Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartinfo}" var="p">
					<tr>
					
						<td class="tabledisplay"><img src="${cr }/pimg/${p.product_Details.product_Id}.jpeg"
							height="50px"></td>
						<td class="tabledisplay">${p.product_Details.product_Name} <c:if test="${error1  && prodid == p.product_Details.product_Id}">
				<div class="alert alert-danger">
					<strong>${message}</strong>
				</div>
			</c:if>
	      <c:if test="${error2 && prodid == p.product_Details.product_Id}">
		        <div class="alert alert-warning">
		     	<strong>${message}</strong>
		        </div>
	        </c:if></td>					
						<td class="tabledisplay">${p.product_Details.product_Price}</td>
                        <td class="tabledisplay">
                           <form action="${cr }/addtocart" method="post">
                           
                                <button type="submit"  style ="visibility:hidden;" id="myBtn" > </button>
                                <a href="${cr }/addtocart?productid=${p.product_Details.product_Id}&quantity=${p.product_Quantity-1}&cartstatus=true" ><i class="fa fa-minus-circle" style="color:green;" ></i></a>
                                <input type="number"  style="border-color:green; width: 30px; height:25px;text-align: center;" min="1" id="quantity" name="quantity" value="${p.product_Quantity}">
                                <input type="hidden" id="productid" name="productid" value="${p.product_Details.product_Id}">
                                <input type="hidden" id="cartstatus" name="cartstatus" value="true">
                                 <a href="${cr }/addtocart?productid=${p.product_Details.product_Id}&quantity=${p.product_Quantity+1}&cartstatus=true" ><i class="fa fa-plus-circle" style="color:green;"></i></a>
                                    <button style ="visibility:hidden;"  > </button>
                               
                           </form>                        
                        </td>
                        <td class="tabledisplay" style="text-align: left;" >&nbsp &#x20B9 <fmt:formatNumber type="number" maxFractionDigits="2" value="${p.product_Details.product_Price*p.product_Quantity}"/>
                        <a style="float: right;"  href="${cr }/deletefromcart?cartid=${p.cart_Id}" ><i class="fa fa-times-circle" style="color:red;"></i></a></td>
                        
                        
					</tr>
					<script>
                           var input = document.getElementById("myInput");
                           input.addEventListener("keyup", function(event) {
                           if (event.keyCode === 13) 
                           {
                               event.preventDefault();
                               document.getElementById("myBtn").click();
                             }
                          });
                  </script>
					
					
				</c:forEach>
			
			</tbody>
		</table>
        
	</div>
	
	

</c:if>
</body>
</html>