<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 9 Implicit Objects in JSP 
Object-type
out-JspWriter
request-HttpServletRequest
response-HttpServletResponse
session-HttpSession
*********************************
application-ServletContext
pageContext-PageContext
page-PageContext
config-ServletConfig
exception-Throwable
-->

<%
out.print("hello");
String n=(String)request.getAttribute("name");
response.getWriter().print(n);
session.setAttribute("Name", "Brijesh");
String name=(String)session.getAttribute("Name");
out.print(name);
%>

</body>
</html>