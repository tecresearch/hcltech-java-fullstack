<%@ include file="../../reusable-code/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="bg-light text-center">
 <div class='bg-image'>
   <div class="container py-5">
	 <div class="card mx-auto shadow ch" style='max-width: 40%'>
	   <div class="card-body py-0">
		 <form action="transfer.do">
		   <p class='fs-3 py-0 text-primary'>Transfer Form(Enter amount)</p>
		   <div class="row fs-6">
		    <div class="col-6 text-start text-dark"><b>Account Holder</b></div>
		    <div class="col-6 text-end text-danger">${sessionScope.rname}</div>
		   </div>
		   <div class="row fs-6 py-2">
		    <div class="col-6 text-start"><b>Account Number</b></div>
		    <div class="col-6 text-end text-danger">${sessionScope.raccountno}</div>
		   </div>
		   <p><input type="text" value="${amount}" class="form-control text-center" name="amount" placeholder="Enter amount"></p>
		   <button class='btn btn-primary'>Submit</button>
		   <button type="button" class='btn btn-secondary' onclick="history.back()">Back Home</button>
		   <p class='my-1'><span class='text-danger'>${msg}</span></p>
		  </form>
		 </div>
		</div>
	  </div>
	</div>
	<%@ include file="../../reusable-code/footer.jsp"%>
</body>
</html>
