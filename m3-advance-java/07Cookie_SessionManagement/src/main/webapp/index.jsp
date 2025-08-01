<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Session Management</title>
<style>
body {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	font-size: 1em;
	background-color: gainsboro;
	padding: 0;
	margin: 0;
	font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI',
		Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue',
		sans-serif;
}

.nav {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	gap: 16em;
	height: auto;
	background-color: darkslategray;
	width: 100vw;
}

ul {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	gap: 1em;
	list-style-type: none;
	color: white;
}

li {
	cursor: pointer;
	padding: 0.3em;
	border-radius: 1.7em;
}

li:hover {
	background-color: rgba(64, 128, 128, 0.7);
}

a {
	color: white;
	text-decoration: none;
}

.main {
	background-color: rgba(64, 128, 128, 0.8);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	font-size: 2em;
	font-family: cursive;
	color: rgb(0, 64, 64);
	height: 100vh;
	width: 100vw;
}

button {
	font-size: 1em;
	background-color: rgba(64, 128, 128, 0.5);
	border-radius: 1em;
}

button:hover {
	cursor: pointer;
	background-color: rgba(64, 128, 128, 0.7);
}
</style>
</head>
<div>
	<div class="nav">
		<ul>
			<li>Your Logo</li>
		</ul>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a name="#" href="about">About</a></li>
			<li><a href="#">Service</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
		<ul>
			 <%
                // Check if session exists and user is logged in
                HttpSession sh = request.getSession(false);
                if (sh != null && sh.getAttribute("session_email") != null) {
                    out.print("<li><a href='dashboard'>Dashboard</a></li>");
                } else {
                    out.print("<li><a href='register.html'>Register</a></li>");
                    out.print("<li><a href='login.html'>Login</a></li>");
                }
            %> 
		</ul>

	</div>

	<div class="main">
		<h1>Welcome to your website</h1>
		<p>This website helps you to learn session management</p>
		<button>Get Started</button>
	</div>
	</body>
</html>