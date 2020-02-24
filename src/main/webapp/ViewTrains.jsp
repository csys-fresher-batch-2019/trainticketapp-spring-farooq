<%@page import="java.util.Iterator"%>
<%@page import="com.chainsys.viewtrains.ListTrain"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>

<body>
<h3>SEARCH TRAINS</h3>
	<form action="ViewTrains">
		<input list="source_station_list" name="source" placeholder="FROM ">
		<datalist id="source_station_list">
			<option value="chennai">
			<option value="trichy">
			<option value="madurai">
			<option value="tirunelveli">
		</datalist>


		<input list="destination_station_list" name="destination"placeholder="TO">
		<datalist id="destination_station_list">
			<option value="chennai">
			<option value="trichy">
			<option value="madurai">
			<option value="tirunelveli">
		</datalist>


		ENTER TRAVEL DATE: <input type="date" name="Traveldate"
			min="2020-01-02" max="2020-05-02" placeholder="Select Travel Date"><br>
		<BR />

		<button type="submit">FIND TRAINS</button>
	</form>
	<form action="Booking">

		<%
			ArrayList<ListTrain> trainList = (ArrayList) request.getAttribute("trains");
		%>
		<%--Assigning ArrayList object containing Employee data to the local object --%>


		<table cellspacing="2" cellpadding="2">

			<tr>
				<th>Train Number</th>
				<th>Train Name</th>
				<th>Travel Date</th>
				<th>Source</th>
				<th>destination</th>
				<th>arrival Time</th>
				<th>Dept Time</th>
				<th>Route</th>
				<th>Status</th>
				<th>Amount</th>
			</tr>
			<%
				// Iterating through subjectList

				if (trainList != null) {

					for (ListTrain trainDetails : trainList) {
			%>
			<%
				int a = trainDetails.getTrainnumber();
						HttpSession session1 = request.getSession();
						session1.setAttribute("trainnumber", a);
			%>
			<tr>
				<td><%=trainDetails.getTrainnumber()%></td>
				<td><%=trainDetails.getTrainname()%></td>
				<td><%=trainDetails.getDate()%></td>
				<td><%=trainDetails.getBoardingstation()%></td>
				<td><%=trainDetails.getDestinationstation()%></td>
				<td><%=trainDetails.getArrivaltime()%>
				<td><%=trainDetails.getDepaturetime()%>
				<td><%=trainDetails.getRoute()%>
				<td><%=trainDetails.getStatus()%>
				<td><%=trainDetails.getAmount()%> <a
					href="Booking.jsp?trainnumber=<%=a%>">BOOK</a>
			</tr>

			<%
				}
				}
			%>


		</table>

		<%
			
		%>




	</form>




</body>
</html>