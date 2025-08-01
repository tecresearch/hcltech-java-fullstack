<%@ include file="../user-header.jsp" %>
<html>
<head>
<script>
document.addEventListener("keydown", function (event) {
    if (event.key === "F5" || (event.ctrlKey && event.key === "r")) {
        event.preventDefault();
    }
});
</script>
</head>
<body class="bg-light text-center" onload="stopRefresh()">
   <div class="bg-image">
	<div class="container py-5">
		<div class="card mx-auto shadow" style="max-width: 50%;">
			<div class="card-body">
				<p class="fs-2 card-text display-6 text-success" >${username}</p>
				<p class="fs-2 card-title">You have been registered successfully</p>
				<p class="card-text display-6 text-success">Your account number is <span id="accountno">${accountno}</span></p>
				<a class='btn btn-primary' href="/janta-bank">Click here to login</a>
			</div>
		</div>
	</div>
    </div> 	
	<%@ include file="../../reusable-code/footer.jsp" %>
</body>
</html>
