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
		List<OrderItem> orderList = (List<OrderItem>) request.getAttribute("orderItemList");
		%>
		<table border="1">
			<tr>
				<th>Order Date</th>
				<th>Product Name</th>
				<th>Product Quantity</th>
				<th>Product Price</th>
			</tr>
			<%
			for (OrderItem orderItem : orderList) {
			%>
			<tr>
				<td><%=orderItem.getCreatedDate()%></td>
				<td><%=orderItem.getProductName()%></td>
				<td><%=orderItem.getQuantity()%></td>
				<td><%=orderItem.getPrice()%></td>
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