<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.example.demo.model.Products"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>List of Products</h1>
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
			</tr>
			<%
			}
			%>
		</table> <br>
		<a href="dashboard.jsp">Click here</a> to back to the main Menu
	</div>
</body>
</html>