<%
   String name=request.getParameter("username");
   String pass=request.getParameter("password");
   if(name.equals("admin") && pass.equals("cetpa"))
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
%>
