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


div.box{
  
  width: 100%;
  border: 1px solid black;
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
				<ins>Address  Details</ins>
			</p>
			
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
			
<c:if test="${empty addresslist}">

<button type="button"  style="text-align: left; font-size: 22px;" class="btn btn-outline-dark btn-lg btn-block" data-toggle="modal" data-target="#addressModal"><i class="fa fa-plus" aria-hidden="true"></i>&nbsp &nbsp Add New Address</button>

</c:if>
<c:if test="${not empty addresslist}">

<button type="button"  style="text-align: left; font-size: 22px;" class="btn btn-outline-dark btn-lg btn-block" data-toggle="modal" data-target="#addressModal"><i class="fa fa-plus" aria-hidden="true"></i>&nbsp &nbsp Add New Address</button>

<c:forEach items="${addresslist}" var="a">
<div class="box">
  <div class="row">
			<aside class="col-sm-2">			
			<a href="${cr }/user/placeorder?addressid=${a.address_Id}"><img src="${cr }/img/${a.address_Type}.png" alt="LOGO" style="margin:10px;width:150px;height:100px;"></a>
			</aside>
			<aside class="col-sm-6">
			<a href="${cr }/user/placeorder?addressid=${a.address_Id}" style="color: black; text-decoration: none;">			
			<h2>${a.customer_Name} -${a.customer_PhoneNo}</h2>
			<h4>${a.address_Area}</h4>
			<h4>${a.address_State},&nbsp${a.address_Country} - ${a.address_Pincode}</h4>
			</a>
			</aside>
			
			<aside class="col-sm-4">
			<a style="float: right;margin-right:15px;margin-top: 3px;" href="${cr }/user/deleteaddress?addressid=${a.address_Id}"><i class="fa fa-trash fa-lg" style="color:red;"></i></a>			
			<a style="float: right;margin-right:10px;margin-top: 5px;" href="${cr }/user/getaddresstoedit?addressid=${a.address_Id}" ><i class="fa fa-edit fa-lg" style="color:blue;"></i></a>
			<a style="float: right;margin-right:15px;margin-top: 5px;" href="${cr }/user/placeorder?addressid=${a.address_Id}" ><i class="fa fa-check-circle fa-lg" style="color:green;"></i></a>
			</aside>
</div>
</div>

</c:forEach>

</c:if>

<!-- Modal -->
<div class="modal fade" id="addressModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Enter Your Address Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
           <form action="${cr }/user/addaddress" method="post">
      
      <div class="modal-body">

            <div class="row">
			<aside class="col-sm-6">
			<label for="customer_name"><b style="font-size: 100%;">Name</b></label>
			<input type="text" placeholder="Enter Your Name" id="customer_name" name="customer_name" required="required">
			</aside>
			
			<aside class="col-sm-6">
			<label for="customer_phnno"><b style="font-size: 100%;">Phone Number</b></label>
			<input type="text" placeholder="Enter Your Mob. No." id="customer_phnno" name="customer_phnno" pattern="^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[6-9]\d{9}$" required="required">
			</aside>
			</div>
			
             <div class="row">
			<aside class="col-sm-12">
			<label for="address_area"><b style="font-size: 100%;">DoorNo./Area/Street</b></label>
			<textarea maxlength="200"  style="font-size:90%;height:70px;" id="address_area" name="address_area" placeholder="Enter your Location..."  required="required"></textarea>
			</aside>
			</div>
			
			 <div class="row">
			<aside class="col-sm-6">
		    <label for="address_state"><b style="font-size: 100%;">State</b></label>
			<input type="text" placeholder="State" id="address_state" name="address_state"  required="required" >
			</aside>
			
             <aside class="col-sm-6">
            <label for="address_country"><b style="font-size: 100%;">Country</b></label>
			<input type="text" placeholder="Country" id="address_country" name="address_country" required="required">
			</aside>
			</div>
            
             <div class="row">
			<aside class="col-sm-6">
			<label for="address_pincode"><b style="font-size: 100%;">Pincode</b></label>
			<input type="text" placeholder="Pincode" id="address_pincode" name="address_pincode"   pattern="^[1-9][0-9]{5}$" required="required">
			</aside>
			
			<aside class="col-sm-6">
			 <label for="address_type"><b style="font-size: 100%;">Address type</b></label>
           <select id="address_type" name="address_type"  required="required">
           <option value="Home">Home</option>
           <option value="Work">Work</option>
           </select> 
           </aside>
           </div>
           

		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      </form>   
    </div>
  </div>
</div>

</div>
</body>
</html>