<%@page import="com.chainsys.Util.Logger"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.chainsys.dao.impl.RegistrationImplementation"%>
<%@page import="com.chainsys.dao.impl.Bookingimplements"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String result = request.getParameter("status");



if(result.equals("Transaction Successfull")){
	Logger.getInstance().info("TRANSACTION SUCCESSFULL");
}
else
{
RegistrationImplementation obj = new RegistrationImplementation();
obj.deleteUser();
Logger.getInstance().info("BANK DOES NOT RESPOND YOUR TRANSACTION");
}

request.setAttribute("result",result);
%>

</body>
</html>