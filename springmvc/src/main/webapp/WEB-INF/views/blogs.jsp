<%@page import="com.jspiders.springmvc.dto.Role"%>
<%@page import="com.jspiders.springmvc.dto.WebBlogDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
	<form action="./sort">
		<select name="index" required="required">
			<option value="1">NEWEST FIRST</option>
			<option value="0">OLDEST FIRST</option>
		</select> <input type="submit" value="Sort">
	</form>
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