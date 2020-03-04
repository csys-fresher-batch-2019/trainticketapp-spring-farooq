<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.model.ListTrain"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<style>
body {
	background-image: url("download (1).jpg");
	background-color: #cccccc;
	background-size: 100% 100%;
}
</style>
<style>
.color-me {
	color: #0000FF;
}
</style>
<style>
/* Navbar container */
.navbar {
	overflow: hidden;
	background-color: #333;
	font-family: Arial;
}

/* Links inside the navbar */
.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* The dropdown container */
.dropdown {
	float: left;
	overflow: hidden;
}

/* Dropdown button */
.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	/* Important for vertical align on mobile phones */
	margin: 0; /* Important for vertical align on mobile phones */
}

/* Add a red background color to navbar links on hover */
.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: black;
}

/* Dropdown content (hidden by default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

/* Add a grey background color to dropdown links on hover */
.dropdown-content a:hover {
	background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}
</style>
<style>
/*set border to the form*/
form {
	border: 3px solid #f1f1f1;
}
/*assign full width inputs*/
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
/*set a style for the buttons*/
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}
/* set a hover effect for the button*/
button:hover {
	opacity: 0.8;
}
/*set extra style for the cancel button*/
.cancelbtn {
	width: auto;
	padding: 5px 10px;
	background-color:;
}
/*centre the display image inside the container*/
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}
/*set image properties*/
img.avatar {
	width: 40%;
	border-radius: 50%;
}
/*set padding to the container*/
.container {
	padding: 16px;
}
/*set the forgot password text*/
span.psw {
	float: right;
	padding-top: 16px;
}
/*set styles for span and cancel button on small screens*/
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

.color {
	color: #ffffff
}
</style>

<title>BookRails</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String) session.getAttribute("name");
	%>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="AdminIndex.jsp">BookRail</a>
				<ul class="nav navbar-nav navbar-right">

			  <%
						if (name == null) {
					%>  
					 
	
					<li><a href="Registration.jsp"> <span
							class="glyphicon glyphicon-user"></span> Sign Up
					</a></li>
					<li><a href="Login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
			 
			 <%
						}else{
			%>
			</div>
			<span class="glyphicon glyphicon-user"></span>
			<c class="color" />
			WELCOME <%=name %>
			<a href="">Add Trains</a> <a href="">Update Trains</a> <a
				href="UpdateSeatsCount.jsp">Update seats Count</a> <a
				href="BlockUser.jsp">Block User</a> <a href="LogoutServlet"><span
				class="glyphicon glyphicon-log-out"></span> Logout</a>

<%
}%>




			</ul>
		</div>
		</div>
	</nav>
	<h2>
		<center>Admin Page</center>
	</h2>
</body>
</html>