<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Say Hello</title>
</head>
<body>

	<div style="text-align: center">
		<h1>Admin Panel</h1>
		<hr>
		<h2>
			<%
			String user = (String) request.getAttribute("username");
			%>
			<%=user != null ? user : "No message available."%></h5>
		</h2>
		<h2>
			<%
			String pass = (String) request.getAttribute("password");
			%>
			<%=pass != null ? pass : "No message available."%></h5>
		</h2>
		<a href="login">logout</a>
	</div>
</body>
</html>