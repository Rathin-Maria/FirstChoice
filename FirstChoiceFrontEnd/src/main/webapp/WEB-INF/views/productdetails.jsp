<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>

@import
	url(https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css);

.gallery-wrap .img-big-wrap img {
	height: 200px;
	width: 200px;
	/* width: auto;*/
	display: inline-block;
	cursor: zoom-in;
	padding-top: 5%;
}

.gallery-wrap .img-small-wrap .item-gallery {
	width: 70px;
	height: auto;
	margin: 7px 2px;
	display: inline-block;
	overflow: hidden;
}

.gallery-wrap .img-small-wrap {
	text-align: center;
}

.gallery-wrap .img-small-wrap img {
	max-width: 100%;
	max-height: 100%;
	object-fit: cover;
	border-radius: 4px;
	/*cursor: zoom-in;*/
}

.price-title {
	font-weight: 700;
}

.price {
	font-size: 24px;
	line-height: 31px;
	text-transform: uppercase;
	max-height: 66px;
	overflow: hidden;
	font-family: 'Open Sans', Arial, sans-serif;
	font-weight: 700;
	width: 100%;
	padding: 0;
	float: none;
}

.color-price-waanbii {
	color: #FA3A11;
}

.color-box-waanbii {
	background: #15cdc7;
	color: white;
}

.fa-beat {
	animation: fa-beat 5s ease infinite;
}
 #justpushtobottom {
	height: 40%;
}

@
keyframes fa-beat { 0% {
	transform: scale(1);
}
5%
{
transform
:scale
(1
.25
);

  
}
20%
{
transform
:scale(1)
;

  
}
30%
{
transform
:scale(1)
;

  
}
35%
{
transform
:scale
(1
.25
);

  
}
50%
{
transform
:scale(1)
;

  
}
55%
{
transform
:scale
(1
.25
);

  
}
70%
{
transform
:scale(1)
;

  
}
}
</style>


</head>
<body>

<div class="container">
	<div class="card border-0">
		<div class="row">
			<aside class="col-sm-4">
				<article class="gallery-wrap">
					<div class="img-big-wrap">
						<div>
							<img src="${cr }/pimg/${product.product_Id}.jpeg">
						</div>
					</div>
				</article>
			</aside>
			<aside class="col-sm-5">
				<article class="card-body m-0 pt-0 pl-5">
					<h3 class="title text-uppercase">${product.product_Name}</h3>
					<div class="mb-3 mt-3">
					<c:if test="${product.product_Stock > 5}">
						<span class="h7 text-success"> ${product.product_Stock} Available</span>
					</c:if>
					<c:if test="${product.product_Stock < 5  && product.product_Stock >0}">
						<span class="h7 text-warning">Only  ${product.product_Stock}  Available</span>
					</c:if>
					<c:if test="${product.product_Stock == 0}">
						<span class="h7 text-danger" style="color:red;">Out of stock</span>
					</c:if>
					</div>
					<div class="mb-3 mt-3">
						<span class="price-title">Price :</span> <span
							class="price color-price-waanbii">&#x20B9 ${product.product_Price}/-</span>
					</div>
					<div class="item-property">
						<span class="price-title">Description:</span> <span>${product.product_Description}</span>
					</div>
					
				</article>
			</aside>
			<c:if test="${product.product_Stock != 0}">
			<aside class="col-sm-3">
				<div class="row" style="padding-top: 50%;">
			  <a href="addToCart?pid=${product.product_Id}"
						class="btn btn-lg color-box-waanbii" type="button"> <i
						class="fa fa-shopping-cart"></i> Add to Cart
					</a>
				</div>
			</aside>
			</c:if>
			<c:if test="${product.product_Stock == 0}">
			<aside class="col-sm-3">
				<div class="row" style="padding-top: 50%;">
					<a href=""
						class="btn btn-lg color-box-waanbii" type="button">  Out of Stock
					</a>
				</div>
			</aside>
			</c:if>
		</div>
	</div>
</div>


</body>
</html>