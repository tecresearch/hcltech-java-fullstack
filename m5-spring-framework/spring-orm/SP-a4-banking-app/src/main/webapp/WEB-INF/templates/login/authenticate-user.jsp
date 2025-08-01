<%@page import="java.sql.*"%>
<html>
<head>
  <link href='/banking-app/resources/CSS/style.css' rel='stylesheet'>
  <link href='/banking-app/resources/CSS/bootstrap.min.css' rel='stylesheet'>
</head>
<body class='bgi'>
 <%
 String uid=request.getParameter("userid");
 PreparedStatement psSelectUser=(PreparedStatement)application.getAttribute("selectUser");
 psSelectUser.setString(1,uid);
 ResultSet rst=psSelectUser.executeQuery();
 if(rst.next())
 {
	 String upassword=request.getParameter("password");
	 String dpassword=rst.getString(2);
	 if(upassword.equals(dpassword))
	 {
		 String name=rst.getString(3);
		 session.setAttribute("username",name);
		 PreparedStatement psSelectAccountNo=(PreparedStatement)application.getAttribute("selectAccountNo");
		 psSelectAccountNo.setString(1,uid);
		 ResultSet rst1=psSelectAccountNo.executeQuery();
		 rst1.next();
		 int accountno=rst1.getInt(1);
		 session.setAttribute("accountno",accountno);
		 response.sendRedirect("/banking-app/home");
	 }
	 else
	 {
		 %>
		 <jsp:include page="login-form.jsp">
		   <jsp:param name="msg" value="Password is wrong" />
   		   <jsp:param name="uid" value="<%=uid%>" />
		 </jsp:include>
		 <% 
	 }
 }
 else
 {
	 %>
	 <jsp:include page="login-form.jsp">
	   <jsp:param value="User id does not exist" name="msg"/>
	   <jsp:param value="<%=uid%>" name="uid"/>
	 </jsp:include>
	 <%
 }
 %>
</body>
</html>
