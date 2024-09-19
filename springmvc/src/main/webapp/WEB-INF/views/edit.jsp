<%@page import="com.jspiders.springmvc.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	UserDTO user = (UserDTO) request.getAttribute("user");
	%>
	<div align="center">
		<form action="./update-user" method="post">
			<table border="1px solid">
				<tr>
					<td>id</td>
					<td><input type="text" name="id" required="required"
						value="<%=user.getId()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>username</td>
					<td><input type="text" name="username" required="required"
						value="<%=user.getUserName()%>"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="email" name="email" required="required"
						value="<%=user.getEmail()%>"></td>
				</tr>
				<tr>
					<td>mobile</td>
					<td><input type="text" name="mobile" required="required"
						value="<%=user.getMobile()%>"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password" required="required"
						value="<%=user.getPassword()%>"></td>
				</tr>
			</table>
			<input type="submit" value="Update">
		</form>
	</div>
</body>
</html>