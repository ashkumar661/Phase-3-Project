<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<%session.invalidate(); %>
		<h2>Logout Successfull</h2>
		<br> <br> <a href="login.jsp">click here</a> to Login
	</div>
</body>
</html>