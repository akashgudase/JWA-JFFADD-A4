<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="./add-user" method="post">
			<table border="1px solid">
				<tr>
					<td>username</td>
					<td><input type="text" name="username" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="email" name="email" required="required">
					</td>
				</tr>
				<tr>
					<td>mobile</td>
					<td><input type="text" name="mobile" required="required"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td>role</td>
					<td><select name="role">
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