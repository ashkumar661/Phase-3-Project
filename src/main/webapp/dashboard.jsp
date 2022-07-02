<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
	<div align="center">
		<h1>Sporty Shoes</h1>
		<br> <br>
		<h4>
			Welcome
			<%=session.getAttribute("userName")%></h4>
		<br> <a href="logout.jsp">Logout</a> <br>
		<p>Select an option from below -</p>
		<table>
			<tr>
				<td><a href="manageProducts.jsp">Manage Products</a></td>
			</tr>
			<tr>
				<td><a href="/listusers">View the list of Users</a></td>
			</tr>
			<tr>
				<td><a href="/listAllPurchaseOrder">View purchase reports</a></td>
			</tr>
		</table>
	</div>
</body>
</html>