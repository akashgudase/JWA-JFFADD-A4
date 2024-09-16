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
		<form action="">
			<table border="1px solid">
				<tr>
					<td>email</td>
					<td><input type="email" name="email" required="required">
					</td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
			</table>
			<input type="submit" value="Login">
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