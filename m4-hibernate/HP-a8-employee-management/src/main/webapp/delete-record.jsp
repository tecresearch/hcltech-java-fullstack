
<%@page import="com.hcl.model.Employee"%>
<%@page import="com.hcl.repository.EmployeeRepository"%>
<%@ include file="navbar.jsp"%>
<html>
<body onload="makeActive('delete')">
	<%
	int eid = Integer.parseInt(request.getParameter("eid"));
	EmployeeRepository empl = new EmployeeRepository();
	empl.deleteEmployee(eid);
	%>
	<div class='dv'>
		<label class='lamsg' style='color: green'>Employee with id <%=eid%>
			has been deleted successfully
		</label>
	</div>
</body>
</html>