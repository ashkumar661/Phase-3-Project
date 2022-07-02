<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
</head>
<body>
	<div align="center">
		<h1>Manage Products</h1>
		<br>
		<h2>
			<form onclick="this.form.action" action="addProduct.jsp">
				<input type="submit" value="Add a product">
			</form>
			&nbsp;&nbsp;&nbsp;
			<form onclick="this.form.action" action="/getproductlist" method="get">
				<input type="submit" value="List products">
			</form>
		</h2>
	</div>
</body>
</html>