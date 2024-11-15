<%@page import="com.jspiders.servlets.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.jspiders.servlets.data.DataAccess"%>
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
	padding: 20px;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:hover {
	background-color: #f5f5f5;
}

h1 {
	color: #333;
}

.not-found {
	text-align: center;
	margin-top: 50px;
}
</style>
</head>
<body>
	<%!DataAccess access = new DataAccess();%>
	<%
	List<User> users = access.findAllUsers();
	if (users.size() > 0) {
	%>
	<div align="center" class="container">
		<table>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Password</th>
				<th colspan="2">Action</th>
			</tr>
			<%
			for (User user : users) {
			%>
			<tr>
				<td><%=user.getUserName()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getMobile()%></td>
				<td><%=user.getPassword()%></td>
				<td><a href="./update-user?email=<%=user.getEmail()%>">Update</a></td>
				<td><a href="./delete-user?email=<%=user.getEmail()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	} else {
	%>
	<div align="center" class="not-found">
		<h1>Users not found</h1>
	</div>
	<%
	}
	%>
</body>
</html>