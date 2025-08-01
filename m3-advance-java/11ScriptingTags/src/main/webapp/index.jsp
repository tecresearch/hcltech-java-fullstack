<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Scanner"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!

abstract class Input {
	abstract String iO();
}

%>
<%

class Get extends Input{
	
	@Override
	String iO(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your name:");
		String name=sc.nextLine();
		return name;
	}
	
}
Get g=new Get();
String name=g.iO();
%>

<%= name %>
</body>
</html>