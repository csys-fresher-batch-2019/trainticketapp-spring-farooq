<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type = "text/javascript">
         <!--
            function Redirect() {
               window.location = "http://192.168.56.231:8090/webciti/PaymentServlet.java?a=1&b=2&c=3";
            }
         //-->
      </script>
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

<%
String amount=request.getParameter("amount");
%>

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


<h3>Payments Page</h3>
<form action="PaymentServlet" method="post">
Merchant Id : <input type="number" name="merchantid" value="6789012340" readonly  /> <br/>
User Mobile No : <input type="number" name="mobileno" pattern=[0-9]{10} required /> <br/>
Amount: <input name="amount" value=<%=amount %> readonly/> <br/> <br/>
<input type="hidden" name="redirect_url" value="success.jsp" />
<!-- <input type = "button" value = "Redirect Me" onclick = "Redirect();" /> -->
<button type="submit">Submit</button>
</form>
</body>
</html>