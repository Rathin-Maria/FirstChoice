<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family:calibri;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 6px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
  font-size:150%;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.sub
{
 font-size:100%;
}
.title {
  color: grey;
  font-size:110%;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size:100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>
</head>
<body>
<div class="about-section">
  <p style="font-size:150%;font-family:algerian;"><ins>About Us Page</ins></p>
  <p style="font-size:70%;font-family:calibri;">
  One Stop Shopping solution for all groceries and goods
  <br>
  <q>Best Price For The Best Quality And Quantity</q>
  <br>
  Q & Q Assured
  </p>
</div>

<p style="font-size:150%;font-family:algerian;text-align:center;"><ins>Our Team</ins></p>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="img/businessman.jpg" alt="CEO" style="width:100%;height:250px;">
      <div class="container">
        <h2  style="font-size:150%;"><b>RK Maria</b></h2>
         <p class="title">CEO And Founder</p>
        <p class="sub">CEO and Founder who started this Project after he saw many People die due to Poverty.</p>
        <p class="sub">rkmaria@firstchoice.com</p>
        <p><button class="button">Contact : 9911199111</button></p>
        <br>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="img/farmer.jpg" alt="Organic Head" style="width:100%;height:250px;">
      <div class="container">
        <h2  style="font-size:150%;"><b>Sanga Mithran</b></h2>
        <p class="title">Organic Head</p>
        <p class="sub">Former farmer and current Organic Division Head involved to verify the quality of goods.</p>
        <p class="sub">sanga@firstchoice.com</p>
        <p><button class="button">Contact : 9923499234</button></p>
        <br>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <img src="img/packing.jpg" alt="Packing Head" style="width:100%;height:250px;">
      <div class="container">
        <h2 style="font-size:150%;"><b>Jegan Ram</b></h2>
        <p class="title">Packing Head</p>
        <p class="sub">Former health officer and current Packing Head for providing hygeine packing environment.</p>
        <p class="sub">jegan@firstchoice.com</p>
        <p><button class="button">Contact : 9912399123</button></p>
      </div>
    </div>
  </div>
</div>

</body>
</html>