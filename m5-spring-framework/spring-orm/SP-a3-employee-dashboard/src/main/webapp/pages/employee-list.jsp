<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <%@ include file="csslink.jsp" %>
 <style>
   a{
     text-decoration: underline;
     font-size:20px;
   }
 </style> 
 <body>
  <div class='dvv'>
   <label class='lal'>EMPLOYEE DASHBOARD</label>
  </div>
  <div class='container'>
    <div>
     <a href="add">Add Employee</a>
    </div>
  	<div class='card col-md-12 mx-auto' style='border:3px solid silver'>
  	  <div class='card-body'>
  	   <div class='table scrollit'>
  	    <table class='table table-hover table-bordered'>
  	     <thead>
  	      <tr>
  	      	<th>Employee id</th><th>First name</th><th>Last name</th>
  	      	<th>Phone number</th><th>Email Id</th><th>Department</th><th>Salary</th>
  	      	<th>Action</th>
  	      </tr>
  	     </thead>
  	     <tbody>
  	     <c:forEach var="employee" items="${elist}">
  	       <tr>
  	        <td>${employee.eid}</td>
  	        <td>${employee.firstname}</td>
  	        <td>${employee.lastname}</td>
  	        <td>${employee.phone}</td>
  	        <td>${employee.email}</td>
  	        <td>${employee.department}</td>
  	        <td>${employee.salary}</td>
  	        <td>
  	         <a href='edit-record?eid=${employee.eid}'>Edit |</a>
  	         <a href='delete-record?eid=${employee.eid}' onclick="return confirm('Are you sure to delete?')">Delete</a>
  	        </td>
  	       </tr>
  	     </c:forEach>
  	     </tbody> 
  	    </table>
  	   </div> 	
  	  </div>
  	</div>
  </div>
 </body>
</html>