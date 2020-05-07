<%@page import="java.time.LocalDate"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
body  {
  background-image: url("download (1).jpg");
  background-color: #cccccc;
  background-size: 100% 100%;
}

</style>

</head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="NewIndex.jsp">BookRail</a>
    </div>
        <div class="collapse navbar-collapse" id="myNavbar">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="NewIndex.jsp">Home</a></li>
      <li><a href="">About</a></li>
      
    </ul>
</div>
</div>
</nav>

<header><h2 >----------------------------------------------------- Registration application-------------------------------------------- </h2></header>

<form name="form" action="Registration" method="post" onsubmit="return validate()">
<table align="center">
 <tr>
 <td>Email</td>
 <td><input type="email" name="email" required/></td>
 </tr>
 <tr>
 <td>Username</td>
 <td><input type="text" name="username" /></td>
 </tr>
 <tr>
 <td>Password</td>
 <td><input type="password" name="password" minlength="8" required/>(min 8 characters)</td>
 </tr>
 <tr>
 <td>Confirm Password</td>
 <td><input type="password" name="conpassword" minlength="8" required/>(min 8 characters)</td>
 </tr>
 <tr>
 <td>Phone Number</td>
 <td><input type="tel" name="phonenumber"  pattern="[0-9]{10}" required/></td>
 </tr>
 <tr>
 <td>Gender</td>
 <td> <input type="radio" name="gender" value="M"> Male
  <input type="radio" name="gender" value="F"> Female</td>
 </tr>
 <%
 LocalDate date = LocalDate.now();
 %>
 <tr>
 <td>Date Of Birth</td>
 <td><input type="date" name="dob" max="<%=date %>"required/></td>
 </tr>
 <tr>
 <td>City</td>
 <td><input type="text" name="city" required/></td>
 </tr>
 
 <%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%>
  <tr>
 <td></td>
 <td><input type="submit" value="Register"></input><input
 type="reset" value="Reset"></input></td>
 <%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>

 </tr>
</table>
</form>
<script type="text/javascript">


</script> 
</body>
</html>