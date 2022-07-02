<%@page import="com.example.demo.model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addtoCart">
		<div align="center">
			<%
			List<Products> list = (List<Products>) request.getAttribute("list");
			%>
			<h1>Product Selection</h1>
			<br>
			<table border="1">
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Category</th>
					<th>Product Type</th>
					<th>Add Quantity</th>
					<th>Action</th>
				</tr>
				<%
				for (Products s : list) {
				%>
				<tr>
					<td><input type="text" name="pName" value="<%=s.getName()%>"></td>
					<td><input type="text" name="pPrice" value="<%=s.getPrice()%>"></td>
					<td><select name="pQuantity" id="pQuantity">
							<option disabled value="" selected>Select a Quantity</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
					</select></td>
					<td><input type="submit" value="Add to Cart"></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</form>
</body>
</html>