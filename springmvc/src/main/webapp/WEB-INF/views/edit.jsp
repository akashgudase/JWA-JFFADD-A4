<%@page import="com.jspiders.springmvc.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

.container {
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	max-width: 400px;
	margin: auto;
}

table {
	width: 100%;
	margin: 20px 0;
}

td {
	padding: 10px;
	text-align: left;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

a {
	display: block;
	text-align: center;
	margin-top: 15px;
	color: #007bff;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%
	UserDTO user = (UserDTO) request.getAttribute("user");
	%>
	<div class="container">
		<form action="./update-user" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" required="required"
						value="<%=user.getId()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" required="required"
						value="<%=user.getUserName()%>"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required="required"
						value="<%=user.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><input type="text" name="mobile" required="required"
						value="<%=user.getMobile()%>"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required"
						value="<%=user.getPassword()%>"></td>
				</tr>
			</table>
			<input type="submit" value="Update">
		</form>
		<a href="home">HOME</a>
	</div>
</body>
</html>
