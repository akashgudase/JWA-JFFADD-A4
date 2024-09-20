<%@page import="com.jspiders.springmvc.dto.Role"%>
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
	if (user.getRole().equals(Role.USER)) {
	%>
	<nav>
		<a href="edit-user">EDIT PROFILE</a> <a href="logout">LOGOUT</a> <a
			href="delete-user">DELETE ACCOUNT</a> <a href="add-blog-page">ADD
			BLOG</a>
	</nav>
	<%
	} else {
	%>
	<nav>
		<a href="edit-user">EDIT PROFILE</a> <a href="logout">LOGOUT</a> <a
			href="delete-user">DELETE ACCOUNT</a>
	</nav>
	<%
	}
	%>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h3><%=message%></h3>
	<%
	}
	%>
</body>
</html>