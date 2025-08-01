<html>
  <%@ include file="csslink.jsp" %>
  <body>
  <div class='dvv'>
   <label class='lal'>ADD EMPLOYEE FORM</label>
  </div>
  <div class='col-6 mx-auto'>
  	<div class='card'>
  	  <div class='card-body'>
  	  <form action="save-record" method="post">
  	   <div class='row'>
  	    <div class='col-12'>
  	      <label for="eid">Enter employee id</label><span> *</span>
  	      <input type="number" class='form-control' name='eid' id='eid' required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-6'>
  	      <label for="firstname">Enter first name</label><span> *</span>
  	      <input type="text" class='form-control' name='firstname' id='firstname' required>
  	    </div>
  	    <div class='col-md-6'>
  	      <label for="lastname">Enter last name</label><span> *</span>
  	      <input type="text" class='form-control' name='lastname' id="lastname" required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-6'>
  	      <label for="phone">Enter phone number</label><span> *</span>
  	      <input type="text" class='form-control' name='phone' id="phone" required>
  	    </div>
  	    <div class='col-md-6'>
  	      <label for="email">Enter email id</label><span> *</span>
  	      <input type="text" class='form-control' name='email' id="email" required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-6'>
  	      <label for="department">Enter department</label><span> *</span>
  	      <input type="text" class='form-control' name='department' id="department" required>
  	    </div>
  	    <div class='col-md-6'>
  	      <label for="salary">Enter salary</label><span> *</span>
  	      <input type="text" class='form-control' name='salary' id="salary" required>
  	    </div>
  	   </div>
  	   <div class='row my-3'>
  	    <div class='col-12 text-center'>
  	     <button class='btn btn-primary'>Save Record</button>
  	     <input type="button" value="Cancel" class='btn btn-secondary' onclick="history.back()">
  	    </div>
  	   </div> 
  	  </form>
  	 </div>
  	</div>
  </div>
 </body>
</html>