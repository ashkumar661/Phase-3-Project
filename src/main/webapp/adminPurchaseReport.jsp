<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.example.demo.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase report</title>
</head>
<body>
	<div align="center">
		<h2>Purchase Report</h2>
		<br>
		<%
		List<Order> list = (List<Order>) request.getAttribute("allOrderList");
		%>
		<table border="1">
			<tr>
				<th>Order ID</th>
				<th>Order Date</th>
				<th>Item Total</th>
				<th>Status</th>				
			</tr>
			<%
			for (Order order : list) {
			%>
			<tr>
				<td><%=order.getId()%></td>
				<td><%=order.getCreatedDate()%></td>
				<td><%=order.getTotalPrice()%></td>
				<td>Completed</td>
			</tr>
			<%
			}
			%>
		</table>
		<br> <a href="dashboard.jsp">Click here</a> to go back to the
		main menu<br>
	</div>
</body>
</html>