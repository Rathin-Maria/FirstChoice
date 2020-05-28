<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
div.row{
margin: 10px;
}
div.box {
	width: 45%;
	height: 467px;
	margin-left:33%;
	border:3px solid green;
}

</style>
<meta charset="ISO-8859-1">
<title>EditAddress</title>
</head>
<body>
<div class="container">
<div class="box">

<p style="font-size: 140%; font-family: algerian; text-align: center; margin-top: 10px;">
				<ins>Address Details</ins>
			</p>


<form action="${cr }/user/updateaddress" method="post">

            <div class="row">
			<aside class="col-sm-6">
			<label for="customer_name"><b style="font-size: 100%;">Name</b></label>
			<input type="text" placeholder="Enter Your Name" id="customer_name" name="customer_name" value="${addressobject.customer_Name}" required="required">
			</aside>
			
			<aside class="col-sm-6">
			<label for="customer_phnno"><b style="font-size: 100%;">Phone Number</b></label>
			<input type="text" placeholder="Enter Your Mob. No." id="customer_phnno" name="customer_phnno" pattern="^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[6-9]\d{9}$" value="${addressobject.customer_PhoneNo}" required="required">
			</aside>
			</div>
			
             <div class="row">
			<aside class="col-sm-12">
			<label for="address_area"><b style="font-size: 100%;">DoorNo./Area/Street</b></label><br>
			<textarea maxlength="200"  style="font-size:90%;height:80px;width: 100%;" id="address_area" name="address_area" placeholder="Enter your Location..."  required="required">${addressobject.address_Area}</textarea>
			</aside>
			</div>
			
			 <div class="row">
			<aside class="col-sm-6">
		    <label for="address_state"><b style="font-size: 100%;">State</b></label>
			<input type="text" placeholder="State" id="address_state" name="address_state"  value="${addressobject.address_State}" required="required" >
			</aside>
			
             <aside class="col-sm-6">
            <label for="address_country"><b style="font-size: 100%;">Country</b></label>
			<input type="text" placeholder="Country" id="address_country" name="address_country" value="${addressobject.address_Country}" required="required">
			</aside>
			</div>
            
             <div class="row">
			<aside class="col-sm-6">
			<label for="address_pincode"><b style="font-size: 100%;">Pincode</b></label>
			<input type="text" placeholder="Pincode" id="address_pincode" name="address_pincode"  value="${addressobject.address_Pincode}"  pattern="^[1-9][0-9]{5}$" required="required">
			</aside>
			
			<aside class="col-sm-6">
			 <label for="address_type"><b style="font-size: 100%;">Address type</b></label>
           <select style="width: 100%;"  id="address_type" name="address_type"  required="required">
           <c:if test = "${addressobject.address_Type == 'Home'}">
           <option value="Home" selected="selected">Home</option>
           <option value="Work">Work</option>
           </c:if>
           <c:if test = "${addressobject.address_Type == 'Work'}">
           <option value="Home">Home</option>
           <option value="Work" selected="selected">Work</option>
           </c:if>
           </select> 
           </aside>
           </div>
        
         <input type="hidden" id="address_id" name="address_id" value="${addressobject.address_Id}">
         <div class="row" style="margin-top: 20px;">
		<aside class="col-sm-6">
		<a href="${cr }/user/selectaddress"><button style="width: 100%;"  type="button" class="btn btn-secondary" >Cancel</button></a>
		</aside>
		<aside class="col-sm-6">
        <button style="width: 100%;" type="submit" class="btn btn-primary">Save</button>
        </aside>
        </div>
      </form> 
      </div>  
      </div>
</body>
</html>