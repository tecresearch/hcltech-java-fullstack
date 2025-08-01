<html>
  <%@ include file="csslink.jsp" %>
  <body>
  <div class='dvv'>
   <label class='lal'>EDIT EMPLOYEE FORM</label>
  </div>
  <div class='col-6 mx-auto'>
  	<div class='card'>
  	  <div class='card-body'>
  	  <form action="update-record" method="post">
  	   <div class='row'>
  	    <div class='col-12'>
  	      <label for="eid">Employee id</label><span> *</span>
  	      <input type="number" value="${employee.eid}" class='form-control' name='eid' id='eid' readonly="readonly">
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-6'>
  	      <label for="firstname">Edit first name</label><span> *</span>
  	      <input type="text" value="${employee.firstname}" class='form-control' name='firstname' id='firstname' required>
  	    </div>
  	    <div class='col-md-6'>
  	      <label for="lastname">Edit last name</label><span> *</span>
  	      <input type="text" value="${employee.lastname}" class='form-control' name='lastname' id="lastname" required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-6'>
  	      <label for="phone">Edit phone number</label><span> *</span>
  	      <input type="text" value="${employee.phone}" class='form-control' name='phone' id="phone" required>
  	    </div>
  	    <div class='col-md-6'>
  	      <label for="email">Edit email id</label><span> *</span>
  	      <input type="text" value="${employee.email}" class='form-control' name='email' id="email" required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-6'>
  	      <label for="department">Edit department</label><span> *</span>
  	      <input type="text" value="${employee.department}" class='form-control' name='department' id="department" required>
  	    </div>
  	    <div class='col-md-6'>
  	      <label for="salary">Edit salary</label><span> *</span>
  	      <input type="text" value="${employee.salary}" class='form-control' name='salary' id="salary" required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-12 text-center'>
  	     <button class='btn btn-primary'>Update Record</button>
  	     <input type="button" value="Cancel" class='btn btn-secondary' onclick="history.back()">
  	    </div>
  	   </div> 
  	  </form>
  	 </div>
  	</div>
  </div>
 </body>
</html>