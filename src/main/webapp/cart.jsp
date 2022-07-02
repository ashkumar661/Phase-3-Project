<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.example.demo.model.*"%>
<%@page import="com.example.demo.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="purchaseOrder">
		<div align="center">
			<h2>Cart</h2>
			<br>
			<%
			List<Cart> list = (List<Cart>) request.getAttribute("list");
			%>
			<table border="1">
				<tr>
					<th>Product Name</th>
					<th>Product Quantity</th>
					<th>Item Total</th>
				</tr>
				<%
				for (Cart c : list) {
				%>
				<tr>
					<td><%=c.getProductName()%></td>
					<td><%=c.getQuantity()%></td>
					<td><%=c.getTotal()%></td>
				</tr>
				<%
				}
				%>

			</table>
			<table border="1">
				<tr>
					<th>Total</th>
				</tr>
				<tr>
					<td><%=request.getAttribute("totalCost")%></td>
				</tr>
			</table>
			<br> <input type="submit" value="Checkout"> <br>
			<a href="userdashboard">Click here</a> to go back to the main menu<br>
		</div>
	</form>
</body>
</html>