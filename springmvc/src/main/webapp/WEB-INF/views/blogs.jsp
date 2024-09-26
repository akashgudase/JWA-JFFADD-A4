<%@page import="com.jspiders.springmvc.dto.Role"%>
<%@page import="com.jspiders.springmvc.dto.WebBlogDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blogs</title>
<style>
/* General styles for the navbar */
.navbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #333;
	padding: 10px 20px;
}

/* Styles for form elements */
.navbar form {
	display: flex;
	align-items: center;
}

/* Select dropdown styles */
.navbar select, .navbar input[type="text"], .navbar input[type="submit"]
	{
	margin: 0 10px;
	padding: 8px 12px;
	border: none;
	border-radius: 4px;
}

/* Style for select dropdown */
.navbar select {
	background-color: #fff;
	color: #333;
}

/* Style for text input */
.navbar input[type="text"] {
	flex: 1;
	background-color: #fff;
	color: #333;
}

/* Style for submit buttons */
.navbar input[type="submit"] {
	background-color: #4CAF50; /* Green */
	color: white;
	cursor: pointer;
	transition: background-color 0.3s;
}

/* Button hover effect */
.navbar input[type="submit"]:hover {
	background-color: #45a049;
}

/* Responsive styles */
@media ( max-width : 600px) {
	.navbar {
		flex-direction: column;
		align-items: flex-start;
	}
	.navbar form {
		width: 100%;
		margin-bottom: 10px;
	}
}

.blog-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	margin: 20px;
}

.blog-card {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 15px;
	margin: 10px;
	width: 300px;
	box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
}

.blog-card h2 {
	font-size: 1.5em;
}

.blog-card p {
	margin: 10px 0;
}

.blog-card a {
	text-decoration: none;
	color: red;
}

.blog-card a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%
	@SuppressWarnings("unchecked")
	List<WebBlogDTO> blogs = (List<WebBlogDTO>) request.getAttribute("blogs");
	Role role = (Role) request.getAttribute("role");
	if (blogs != null) {
	%>
	<div class="navbar">
		<form action="./sort">
			<select name="index" required="required">
				<option value="1">NEWEST FIRST</option>
				<option value="0">OLDEST FIRST</option>
			</select> <input type="submit" value="Sort">
		</form>
		<form action="./search">
			<input type="text" name="query"> <input type="submit"
				value="Search">
		</form>
	</div>
	<div align="center" class="blog-container">
		<%
		for (WebBlogDTO blog : blogs) {
		%>
		<div class="blog-card">
			<h2><%=blog.getTitle()%></h2>
			<p>
				<strong>Content:</strong>
				<%=blog.getContent()%></p>
			<p>
				<strong>Date:</strong>
				<%=blog.getDate()%></p>
			<p>
				<strong>Author:</strong>
				<%=blog.getAuthor()%></p>
			<%
			if (role == null || !role.equals(Role.USER)) {
			%>
			<a
				href="delete-blog?blog-id=<%=blog.getId()%>&user-id=<%=blog.getUserId()%>">Delete</a>
			<%
			}
			%>
		</div>
		<%
		}
		%>
	</div>
	<%
	}
	%>
	<div align="center">
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<h3><%=message%></h3>
		<%
		}
		%>
		<a href="home">HOME</a>
	</div>
</body>
</html>