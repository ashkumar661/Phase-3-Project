<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.example.demo.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Order Details</h2>
		<br>
		<%
		List<Order> orderList = (List<Order>) request.getAttribute("orderDtoList");
		%>
		<table border="1">
			<tr>
				<th>Order ID</th>
				<th>Order Date</th>
				<th>Item Total</th>
				<th>Action</th>
			</tr>
			<%
			for (Order order : orderList) {
			%>
			<tr>
				<td><%=order.getId()%></td>
				<td><%=order.getCreatedDate()%></td>
				<td><%=order.getTotalPrice()%></td>
				<td><a href="getOrderItems?id=<%=order.getId()%>">View Details</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<br> <a href="userdashboard">Click here</a> to go back to the
		main menu<br>
	</div>
</body>
</html>