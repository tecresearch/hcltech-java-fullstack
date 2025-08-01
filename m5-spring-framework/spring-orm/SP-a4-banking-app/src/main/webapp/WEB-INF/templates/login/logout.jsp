<html>
 <head>
  <link href='/banking-app/resources/CSS/style.css' rel='stylesheet'>
 </head>
 <body class='bgi'>
  <div>
    <img src="/banking-app/resources/images/thnk.png" width="100%" height="34%"/>
  </div>
  <hr style='border:2px solid green'><br>
  <div style='margin-top:30pd;color:white ' align='center'>
 	<h1><%=session.getAttribute("username")%> ,thank you for using this app</h1>
 	<h1>You have successfully logged out...</h1>
  </div>
  <%
  session.invalidate();
  %>
  <div style='margin-top:30px;font-family:lucida bright' align='center'>
     <a href='/banking-app/user/login-form.jsp' style='font-size:20px;color:white'>Click here for re-login</a>
  </div>
 </body> 
</html>