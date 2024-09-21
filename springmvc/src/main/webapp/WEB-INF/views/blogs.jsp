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
</head>
<body>
	<%
	@SuppressWarnings("unchecked")
	List<WebBlogDTO> blogs = (List<WebBlogDTO>) request.getAttribute("blogs");
	Role role = (Role) request.getAttribute("role");
	if (blogs != null) {
	%>
	<div align="center">
		<table border="1px solid">
			<%
			if (role.equals(Role.USER)) {
			%>
			<tr>
				<th>Title</th>
				<th>Content</th>
				<th>Date</th>
				<th>Author</th>
			</tr>
			<%
			for (WebBlogDTO blog : blogs) {
			%>
			<tr>
				<td><%=blog.getTitle()%></td>
				<td><%=blog.getContent()%></td>
				<td><%=blog.getDate()%></td>
				<td><%=blog.getAuthor()%></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<th>Title</th>
				<th>Content</th>
				<th>Date</th>
				<th>Author</th>
				<th>Action</th>
			</tr>
			<%
			for (WebBlogDTO blog : blogs) {
			%>
			<tr>
				<td><%=blog.getTitle()%></td>
				<td><%=blog.getContent()%></td>
				<td><%=blog.getDate()%></td>
				<td><%=blog.getAuthor()%></td>
				<td><a href="delete-blog?id=<%=blog.getId()%>">Delete</a></td>
			</tr>
			<%
			}
			}
			%>
		</table>
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