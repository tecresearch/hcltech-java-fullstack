<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>
<%!
    String name = "Welcome";
    java.util.List<String> names = new java.util.ArrayList<>();
    public void init() {
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
    }
%>
<%
    // Ensure the init method is called
    init();
    // Set the names list as a request attribute for EL access
    request.setAttribute("names", names);
%>

<!-- JSP Expression Language (EL) -->
<h4>${name}</h4>
<h4>${23 + 23}</h4>

<!-- Accessing Java List using EL -->
<ul>
    <c:forEach var="n" items="${names}">
        <li>${n}</li>
    </c:forEach>
</ul>

<!-- JSP Scriptlet -->
<%
    String greeting = "Hello, JSP!";
%>
<h4><%= greeting %></h4>

<!-- JSP Declaration -->
<%! 
    public String getCurrentDate() {
        return new java.util.Date().toString();
    }
%>
<h4>Current Date: <%= getCurrentDate() %></h4>

<!-- JSP useBean Action Tag -->
<jsp:useBean id="user" class="com.example.User" scope="page"/>
<jsp:setProperty name="user" property="name" value="John Doe"/>
<h4>User Name: <jsp:getProperty name="user" property="name"/></h4>

<!-- JSP Include Action Tag -->
<jsp:include page="included.jsp"/>

</body>
</html>
