<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Signup</title>
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

h3 {
	color: red;
}

table {
	width: 100%;
	margin: 20px 0;
}

td {
	padding: 10px;
	text-align: left;
}

input[type="text"], input[type="email"], input[type="password"], select
	{
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #5cb85c;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #4cae4c;
}
</style>
</head>
<body>
	<div class="container">
		<form action="./add-user" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><input type="text" name="mobile" required="required"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><select name="role" required="required">
							<option disabled="disabled" selected="selected">SELECT</option>
							<option value="ADMIN">ADMIN</option>
							<option value="USER">USER</option>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="Signup">
		</form>
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<h3><%=message%></h3>
		<%
		}
		%>
	</div>
</body>
</html>