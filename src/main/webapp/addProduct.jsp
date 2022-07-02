<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="adminAddProduct">
			<h1>Add Product</h1>
			<br>
			<table>
				<tr>
					<th>Product Name</th>
					<td><input type="text" name="productName" size="45" /></td>
				</tr>
				<tr>
					<th>Product Price</th>
					<td><input type="number" name="productPrice" size="5" /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Submit" /> <br>
			<a href="dashboard.jsp">Click here</a> to go back to the main menu<br>
		</form>
	</div>
</body>
</html>