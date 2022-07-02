<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page for Student</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<form action="login" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"
						placeholder="Enter username" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"
						placeholder="Enter password" required/></td>
				</tr>
			</table>
			<input type="submit" value="Login" /> <br> <br>
		</form>
		New User? <a href="register.jsp">Register here</a>
	</div>
</body>
</html>