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
	<form action="addtocart">
		<div align="center">
			<h4>Product Selection</h4>
			<br>
			<%
			List<Products> list = (List<Products>) request.getAttribute("list");
			%>
			<table border="1">
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
				</tr>
				<%
				for (Products p : list) {
				%>
				<tr>
					<td><input type="text" name="productID" size="20" 
						value="<%=p.getId()%>" /></td>
					<td><input type="text" name="productName"
						value="<%=p.getName()%>" /></td>
					<td><input type="text" name="productPrice"
						value="<%=p.getPrice()%>" /></td>
					<td><select name="quantity" id="quantity">
							<option disabled value="" selected>Select a quantity</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
					</select></td>
				</tr>
				<%
				}
				%>
			</table>
			<br> <input type="submit" value="Add to Cart"> <br>
			<a href="userdashboard">Click here</a> to go back to the main menu
		</div>
	</form>
</body>
</html>