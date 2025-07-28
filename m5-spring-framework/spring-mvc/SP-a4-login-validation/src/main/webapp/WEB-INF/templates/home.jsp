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
				String message = "Welcome to login portal";
				%>
				<%=message != null ? message : "No message available."%></h5>

			<a href="login">Login</a> 
		</div>
	</form>
</body>
</html>