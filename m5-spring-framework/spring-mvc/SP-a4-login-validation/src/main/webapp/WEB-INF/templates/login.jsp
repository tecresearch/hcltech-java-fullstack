<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Say Hello</title>
</head>
<body>
	<form action="auth">
		<div style="text-align: center">
			<h1>Login Portal</h1>
			<label for="username">Username</label> <input type="text"
				name="username"
				value="<%=(String)request.getAttribute("username")%>" required>
			<br> <label for="password">Password</label> <input
				type="password" name="password" required> <br>
			<button type="submit">Login</button>
		</div>
	</form>
	<div style="text-align: center">
		<h3 style="color: red;">

			<%
			String message = (String) request.getAttribute("sms");
			%>
			<%=message != null ? message : "No message available."%></h5>

		</h3>
	</div>
</body>
</html>