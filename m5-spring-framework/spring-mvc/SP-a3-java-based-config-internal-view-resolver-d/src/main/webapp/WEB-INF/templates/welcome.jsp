<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Say Hello</title>
</head>
<body>
	<form action="/">
		<div style="text-align: center">
			<h1>Welcome to home page</h1>
			<h5>
				<%
				String message = (String) request.getAttribute("message");
				%>
				<%=message != null ? message : "No message available."%></h5>

			<a href="hello">Say Hello</a>
		</div>
	</form>
</body>
</html>