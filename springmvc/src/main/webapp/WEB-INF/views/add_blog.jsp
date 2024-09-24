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
		<form action="./add-blog" method="post">
			<table border="1px solid">
				<tr>
					<td>title</td>
					<td><input type="text" name="title" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>content</td>
					<td><textarea rows="12" cols="24" placeholder="Write here.."
							name="content"></textarea></td>
				</tr>
				<tr>
					<td>author</td>
					<td><input type="text" name="author" required="required"></td>
				</tr>
			</table>
			<input type="submit" value="Add Blog">
		</form>
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