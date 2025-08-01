<%@ include file="../user-header.jsp" %>
<html>
 <body class="bg-light text-center">
   <div class="bg-image">
	<div class="container py-5">
		<div class="card mx-auto shadow" style="max-width: 50%;">
			<div class="card-body">
				<p class="fs-2 card-text display-6 text-success" >${username}</p>
				<p class="fs-2 card-title text-danger">You have been logged out successfully</p>
				<a class='btn btn-primary' href="/janta-bank">Click here to login</a>
			</div>
		</div>
	</div>
    </div> 	
	<%@ include file="../../reusable-code/footer.jsp" %>
</body>
  </body>
</html>