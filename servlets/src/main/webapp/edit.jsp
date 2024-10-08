<%@page import="com.jspiders.servlets.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	padding: 10px;
	vertical-align: middle;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<%
	User user = (User) request.getAttribute("user");
	%>
	<div align="center" class="form-container">
		<form action="./update-user" method="post">
			<table>
				<tr>
					<td>username</td>
					<td><input type="text" name="username"
						value="<%=user.getUserName()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="email"
						value="<%=user.getEmail()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>mobile</td>
					<td><input type="text" name="mobile"
						value="<%=user.getMobile()%>"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="text" name="password"
						value="<%=user.getPassword()%>"></td>
				</tr>
			</table>
			<input type="submit" value="Update">
		</form>
	</div>
</body>
</html>