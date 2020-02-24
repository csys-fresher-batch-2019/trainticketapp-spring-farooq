<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


	<form action="BlockUser">

		Enter User-Id : <input type="number" name=userid required><br>
		<label for="trains">Block User:</label> <select id="trains"
			name="block">
			<option value="1">Block</option>
			<option value="0">UnBlock</option>

		</select>
		<button type="submit">Done</button>

		<%
			String result = (String) request.getAttribute("info");
			if (result != null) {
				PrintWriter out1 = response.getWriter();
				out1.println(result);
			}
		%>

	</form>
</body>
</html>