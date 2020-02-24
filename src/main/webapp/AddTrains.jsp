<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<center>
	<h2>ADD TRAINS</h2>
	<table>
		<form action="AddTrainsServlet">
Enter Train Number:<input type="number" name="trainnumber"><br>
Enter Train Name:<input type="text" name="trainname"><br>
Enter traveldate:<input type="date" name="traveldate"><br>
Enter Boarding Station:<input type="text" name="source"><br>
Enter Destination Station:<input type="text" name="dest"><br>
Enter Arrival Time:<input type="text" name="arrivaltime">As (08:00:00)<br>
Enter Departure Time:<input type="text" name="depttime">As (10:00:00)<br>
Enter Route:<input type="text" name="route"><br>
Set Status:<select id="trains">
  <option value="available running">available running</option>
  <option value="available yet to start">available yet to start</option>
  <option value="not available" disabled>Not Available</option>
  <option value="cancelled" disabled>Cancelled</option>
</select><br>
Enter Amount<input type="number" name="amount" min="0"><br>
			<br>

			<button type="submit">Add Trains</button>
			</table>
		</form>
	</center>
</body>
</html>