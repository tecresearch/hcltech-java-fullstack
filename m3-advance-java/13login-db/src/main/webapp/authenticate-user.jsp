<%@page import="java.sql.*"%>
<%
   String name=request.getParameter("username");
   String pass=request.getParameter("password");
   try
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp10","root","mysql");
	   PreparedStatement ps=cn.prepareStatement("select * from userinfo where username=? and password=?");
	   ps.setString(1,name);
	   ps.setString(2,pass);
	   ResultSet rst=ps.executeQuery();
	   if(rst.next())
	   {
		   response.sendRedirect("home.jsp");
	   }
	   else
	   {
		   %>
		    <jsp:include page="login.jsp" />
		    <div style="text-align: center">
		     <h3 style="color:red">User name or password is incorrect</h3>
		    </div>
		   <%
	   }
   }
   catch(Exception ex)
   {
	   out.println(ex);
   } 
%>
