<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<div align="center">
	<h1>User Registration</h1>
		<form action="register">
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname"
						placeholder="Enter First Name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname"
						placeholder="Enter Last Name" /></td>
				</tr>
				<tr>
					<td>Email ID</td>
					<td><input type="email" name="useremail"
						placeholder="Enter your Email ID" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"
						placeholder="Enter a username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"
						placeholder="Enter a password" /></td>
				</tr>
			</table>
			 <br> <input type="submit" value="Register" />
		</form>
	</div>
</body>
</html>