<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.example.demo.model.Products"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
	<form action="productTypeSelection">
		<div align="center">
			<h1>Sporty Shoes</h1> <br>
			<h3>
				Welcome
				<%=session.getAttribute("userName")%></h3>
			<br> <a href="logout.jsp">Logout</a> <br>
			<a href="listcart">Cart</a> <br> <a
				href="listPurchaseOrder">View Order</a> <br>
			<h4>Product Selection</h4>
			<br>
			<%
			List<Products> list = (List<Products>) request.getAttribute("list");
			%>
			<table border="1">
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
				</tr>
				<%
				for (Products s : list) {
				%>
				<tr>
					<td><%=s.getName()%></td>
					<td><%=s.getPrice()%></td>
					<td><a href="productTypeSelection?id=<%=s.getId()%>">Show
							Details</a></td>
				</tr>
				<%
				}
				%>
			</table>
			<br> <br>
		</div>
	</form>
</body>
</html>