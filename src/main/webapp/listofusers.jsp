<%@page import="com.example.demo.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signed-up user list</title>
</head>
<body>
	<div align="center">
		<%
		List<User> list = (List<User>) request.getAttribute("list");
		%>
		<h1>List of Signed-up User</h1>
		<br>
		<table border="1">
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Email ID</th>
			</tr>
			<%
			for (User s : list) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getFirstName()%></td>
				<td><%=s.getLastName()%></td>
				<td><%=s.getUserName()%></td>
				<td><%=s.getEmail()%></td>
			</tr>
			<%
			}
			%>
		</table> <br>
		<a href="dashboard.jsp">Click here</a> to back to the main Menu
	</div>
</body>
</html>