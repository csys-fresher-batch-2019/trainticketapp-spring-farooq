<%@page import="com.chainsys.model.Booking"%>
<%@page import="com.chainsys.model.ListTrain"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="NewIndex.jsp">BookRail</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav">
					<li class="active"><a href="NewIndex.jsp">Home</a></li>
					<li><a href="">About</a></li>
					<li><a href="MyBookings.java">MyBookings</a></li>

				</ul>
			</div>
		</div>
	</nav>


	<table cellspacing="2" cellpadding="2" border="1">

		<%
			ArrayList<Booking> myBooking = (ArrayList) request.getAttribute("booklist");
		%>


		<%
			// Iterating through subjectList

			if (myBooking != null) {
		%>
		<tr>

			<th>PNR NUMBER</th>
			<th>TRAVEL DATE</th>
			<th>NO OF SEATS</th>
			<th>CURRENT STATUS</th>
			

		</tr>

		<%
			for (Booking book : myBooking) {
		%>

		<tr>
			<td><%=book.getPnrNumber()%></td>
			<td><%=book.getTravel_date()%></td>
			<td><%=book.getNoOfSeats()%></td>
			<td><%=book.getCurrentStatus()%></td>

		</tr>

		<%
			}
			}
		%>


	</table>

	<%
		
	%>








</body>
</html>