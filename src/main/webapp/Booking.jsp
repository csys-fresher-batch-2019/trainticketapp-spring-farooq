<%@page import="java.time.LocalDate"%>
<html>
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
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a href="LogoutServlet">          Logout</a>
</div></div></nav>
<%

			LocalDate date = (LocalDate) session.getAttribute("traveldate");
			String source = (String) session.getAttribute("source");
			String destination = (String) session.getAttribute("destination");
			//int trainnumber = (int) session.getAttribute("trainnumber");
			String trainnumber = request.getParameter("trainnumber");
			int userid =(int) session.getAttribute("userid");
			
		%>
<header><h3>RAIL-TICKET BOOKING</h3></header>
<h2>BOOKING</h2>
<form action="Booking">

<div align="left">
ENTER USER-ID: <input type="number" name="userId" value=<%=userid %> readonly/>
<br/>
SELECT TRAIN : <input type="number" name=trainnumber value=<%=trainnumber %> readonly >

<br/>
 Select Source Station:
 <input type="text" name="source" value=<%=source %> readonly> 

<br/>
 Select Destination Station:
 <input type="text" name="destination" value=<%=destination %> readonly> 
 <br/>


  ENTER TRAVEL DATE:
  <input type="date" name="Traveldate" value=<%=date%> readonly><br>

  ENTER SEATS COUNT:
  <input type="number" name="NoOfSeats" min="1" max="5" placeholder="Enter Seat Count" required autofocus><br>

 <br/>
<ul> <input type="radio" name=payment>CitiPe<br>
<input type="radio" name=payment disabled>Credit Card<br></ul>
<button type="submit">PAY</button>
<button type="reset">RESET</button>
</div>
</form>


</body>
</html>
