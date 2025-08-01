<%@ include file="../../reusable-code/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="bg-light text-center">
	<div class='bg-image'>
		<div class="container py-5">
			<div class="card mx-auto shadow ch" style='max-width: 40%'>
				<div class="card-body py-4">
					<form action="verify-account.do">
						<p class='fs-3 py-0 text-primary'>Transfer Form</p>
						<p>
							<input type="text" value="${sessionScope.raccountno}" class="form-control text-center" name="accountno" placeholder="Enter Account Number">
						</p>
						<button class='btn btn-primary'>Submit</button>
						<button type="button" class='btn btn-secondary'  onclick="history.back()">Back Home</button>
						<p class='my-1'>
							<span class='text-danger'>${msg}</span>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../reusable-code/footer.jsp"%>
</body>
</html>
