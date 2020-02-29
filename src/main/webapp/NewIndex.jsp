<%@page import="java.time.LocalDate"%>
<%@page import="com.chainsys.dao.impl.ViewTrainsimplementation"%>
<%@page import="com.chainsys.dao.impl.Bookingimplements"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.model.ListTrain"%>
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
.orange{
color:#ffffff ;
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
				<a class="navbar-brand" href="NewIndex.jsp">BookRail</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav">
					<li class="active"><a href="NewIndex.jsp">Home</a></li>
					<li><a href="">About</a></li>

					<%
						if (name == null) {
					%>
					<li><a href="Login.jsp">MyBookings</a></li>
					<%
						} else {
					%>
					<li><a href="MyBookings">MyBookings</a></li>
					<%
						}
					%>
				</ul>

				<ul class="nav navbar-nav navbar-right">

					<%
						if (name == null) {
					%>



					<li><a href="Registration.jsp"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="Login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<li><a href="adminlogin.jsp"><span
							class="glyphicon glyphicon-log-in"></span>Admin Login</a></li>

					<%
						} else {
					%>

					<li><div text-align:right>
							<span class="glyphicon glyphicon-user"></span>
							<c class="orange"> WELCOME <%=name%>
						</div></li>
					<li><a href="LogoutServlet"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>


					

					<%
						}
					%>


				</ul>
			</div>
		</div>
	</nav>


	<h3>!! WELCOME TO BOOKRAIL !!</h3>
	<div id="form-wrapper"
		style="max-width: 500px; margin: auto; text-align: left">

		<div style="text-align: center;">
			<div class="heading">
				<label class="heading-font">
					<h3>PLAN YOUR JOURNEY</h3>
				</label> <br> <img alt="Rail Icon" class="mobhide" src="rail_icon.png">

			</div>
			
			<%
			ViewTrainsimplementation obj = new ViewTrainsimplementation();
			ArrayList<String> list1=obj.getTrainDetailsByBoardingStation();
			%>

			<form action="ViewTrains">
				<label> <input list="source_station_list" name="source"
					placeholder="FROM "> <datalist id="source_station_list">
						<%for(String li : list1){ %>
						<option value="<%=li%>"><%=li %></option>
						<%} %>
					</datalist></label><br>
					
					
				<br> <label> <input list="destination_station_list"
					name="destination" placeholder="TO"> <datalist
						id="destination_station_list">
			<%
			ViewTrainsimplementation obj1 = new ViewTrainsimplementation();
			ArrayList<String> list=obj1.getTrainDetailsByDestinationStation();
			%>
			<%for(String li : list){ %>
						<option value="<%=li%>"><%=li %></option>
						<%} %>
			<%
			LocalDate date = LocalDate.now();
			%>
					</datalist></label><br>
				<br> <label> <input type="date" name="Traveldate"
					min="<%=date %>" max="2020-05-02" placeholder="Select Travel Date">
					<br></label> <br>
				<button type="submit" class="cancelbtn">FIND TRAINS</button>

			</form>
			<br>
			<br>

		</div>
	</div>
	<form action="Booking">

		<%
			ArrayList<ListTrain> trainList = (ArrayList<ListTrain>) request.getAttribute("trains");
		%>
		<%--Assigning ArrayList object containing Employee data to the local object --%>

		<table class="table" cellspacing="10" border="1">
				<% 		
			
				if (trainList != null) {
		%>
			<thead>
				<tr>
					<th>Train Number</th>
					<th>Train Name</th>
					<th>Travel Date</th>
					<th>Source Station</th>
					<th>Destination Station</th>
					<th>Arrival Time</th>
					<th>Dept Time</th>
					<th>Route</th>
					<th>Status</th>
					<th>Amount</th>
					<th>Book</th>
				</tr>
			</thead>

		
		<%			
					for (ListTrain trainDetails : trainList) {

						%>
						<tr>
							<td><%=trainDetails.getTrainnumber()%></td>
							<td><%=trainDetails.getTrainname()%></td>
							<td><%=trainDetails.getDate()%></td>
							<td><%=trainDetails.getBoardingstation()%></td>
							<td><%=trainDetails.getDestinationstation()%></td>
							<td><%=trainDetails.getArrivaltime()%></td>
							<td><%=trainDetails.getDepaturetime()%></td>
							<td><%=trainDetails.getRoute()%></td>
							<td><%=trainDetails.getStatus()%></td>
							<td><%=trainDetails.getAmount()%></td>

							<%
								
										if (name==null) {%>
											<td><a href="Login.jsp?">BOOK</a></td>
											</tr>
										<%
							}
										else {
											%>
											<td><a href="Booking.jsp?trainnumber=<%=trainDetails.getTrainnumber()%>">BOOK</a></td>
											<%
											}
							
								
					}
				}		
				
			%>

		</table>
	</form>


</body>
</html>