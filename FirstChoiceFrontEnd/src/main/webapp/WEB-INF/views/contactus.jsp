<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: calibri;
  font-size:100%;
}

* {
  box-sizing: border-box;
}

/* Style inputs */
input[type=text],input[type=email],input[type=tel], select, textarea {
  width: 100%;
  padding: 6px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 9px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 5px 20px;
  border: none;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

/* Style the container/contact section */
.container {
  border-radius: 5px;
  background-color: white;
  padding: 10px;
}

/* Create two columns that float next to eachother */
.column {
  float: left;
  width: 50%;
  margin-top: 0px;
  margin-bottom:1.5%;
  padding: 10px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
</head>
<body>

<div class="container">
  <div style="text-align:center">
    <p style="font-size:150%;font-family:algerian"><ins>Contact Us</ins></p>
    <br>
  </div>
  <div class="row">
    <div class="column">
      <img src="img/logo.png" style="width:100%;height:95%;">
    </div>
    <div class="column">
      <form action="/action_page.php">
        <label for="fname"><b>First Name</b></label>
        <input type="text" id="fname" name="firstname" placeholder="Your First Name..." required>
        <label for="lname"><b>Last Name</b></label>
        <input type="text" id="lname" name="lastname" placeholder="Your Last Name..." required>
        <label for="email"><b>Email Id</b></label>
        <input type="email" id="email" name="email" placeholder="Your Email Id..." required>
		<label for="contact"><b>Contact Number</b></label>
	    <input type="tel" placeholder="Your Contact Number..." pattern="[0-9]{10}"  name="contact" required>
        <label for="subject"><b>Description</b></label>
        <textarea style="font-size:110%;height:120px;" id="subject" name="subject" placeholder="Write Something..."  required></textarea>
        <input type="submit" value="Submit">
      </form>
    </div>
  </div>
</div>

</body>
</html>
