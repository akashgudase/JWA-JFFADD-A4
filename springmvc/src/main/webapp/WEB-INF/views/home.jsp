<%@page import="com.jspiders.springmvc.dto.Role"%>
<%@page import="com.jspiders.springmvc.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

nav {
	background-color: #007bff;
	padding: 15px;
	border-radius: 5px;
	display: flex;
	justify-content: space-around;
}

nav a {
	color: white;
	text-decoration: none;
	padding: 10px 15px;
	border-radius: 5px;
	transition: background-color 0.3s;
}

nav a:hover {
	background-color: #0056b3;
}

h3 {
	color: red;
	text-align: center;
}

p {
	width: 600px;
	font-size: 20px;
	text-align: justify;
	font-family: cursive;
	font-style: italic;
}

h1 {
	margin-top: 100px;
}
</style>
</head>
<body>
	<%
	UserDTO user = (UserDTO) request.getAttribute("user");
	if (user.getRole().equals(Role.USER)) {
	%>
	<nav>
		<a href="edit-user">EDIT PROFILE</a> <a href="logout">LOGOUT</a> <a
			href="delete-user">DELETE ACCOUNT</a> <a href="add-blog-page">ADD
			BLOG</a> <a href="blogs">ALL BLOGS</a> <a href="my-blogs">MY BLOGS</a>
	</nav>
	<div align="center">
		<h1>WELCOME TO WEB BLOGGER</h1>
		<p>Web Blogger is a user-friendly platform that allows you to
			create and manage your own blog effortlessly. With customizable
			templates and an intuitive interface, you can share your thoughts,
			stories, and expertise with the world. Whether you're a seasoned
			writer or just starting out, Web Blogger makes it easy to publish
			your ideas and connect with your audience. Developed by JWA-JFFADD-A4
			group of developers with a vision to empower every user in every part
			of India to benefit from digital India and make in India revolution.</p>
	</div>
	<%
	} else {
	%>
	<nav>
		<a href="edit-user">EDIT PROFILE</a> <a href="logout">LOGOUT</a> <a
			href="delete-user">DELETE ACCOUNT</a> <a href="blogs">ALL BLOGS</a><a
			href="users">ALL USERS</a>
	</nav>
	<div align="center">
		<h1>WELCOME TO WEB BLOGGER</h1>
		<p>Web Blogger is a user-friendly platform that allows you to
			create and manage your own blog effortlessly. With customizable
			templates and an intuitive interface, you can share your thoughts,
			stories, and expertise with the world. Whether you're a seasoned
			writer or just starting out, Web Blogger makes it easy to publish
			your ideas and connect with your audience. Developed by JWA-JFFADD-A4
			group of developers with a vision to empower every user in every part
			of India to benefit from digital India and make in India revolution.</p>
	</div>
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
