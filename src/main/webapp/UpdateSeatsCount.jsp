<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

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

<li><a href="Registration.jsp">

<span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="Login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>

					<%
						} else {
					%>
				
			</div>
					<span class="glyphicon glyphicon-user"></span><c class="color"/> WELCOME <%=name%>
					<ul><a href="">Add Trains</a>
					<a href="">Update Trains</a>
					<a href="UpdateSeatsCount.jsp">Update seats Count</a>
					
					
			<a href="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span> Logout</a></ul>
			



			<%
				}
			%>

		</div>
	</nav>
<form action="UpdateSeats">

<pre><center>Enter Train Number:<input type="number" name="trainnum" required></center></pre>
<br>
<pre><center>Select date	:<input type="date" name="traveldate" required></center></pre>
<br>
<pre><center>Enter seats Count:<input type="number" name="seatcount" min="0" required></center></pre>

<center><button type="submit" class=btn btn-success>Update<%String result = (String)request.getAttribute("errormss"); 
PrintWriter out1 = response.getWriter();
out1.println(result);
%></button></center>

</form>

</body>
</html>