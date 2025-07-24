 
<%@page import="com.hcl.repository.EmployeeRepository"%>
<%@page import="com.hcl.model.Employee"%>
<%@ include file="navbar.jsp" %>
<html>
  <body onload="makeActive('edit')">
  <%
  Employee emp=new Employee();
  emp.setEid(Integer.parseInt(request.getParameter("eid")));
  emp.setFirstname(request.getParameter("firstname"));
  emp.setLastname(request.getParameter("lastname"));
  emp.setPhone(request.getParameter("phone"));
  emp.setEmail(request.getParameter("email"));
  emp.setDepartment(request.getParameter("department"));
  emp.setSalary((request.getParameter("salary")));
  EmployeeRepository employeeRepository=new EmployeeRepository();
  employeeRepository.updateEmployee(emp,(Integer.parseInt(request.getParameter("eid"))));
  %>  
  <div class='dv'>
  	<label class='lamsg' style='color:green'>Employee has been updated successfully</label>
  </div>
 </body>
</html>