<%@ include file="../../reusable-code/header.jsp" %>
<body class="bg-light text-center">
  <div class='bg-image'>
   <div class="container py-5">
        <div class="card mx-auto shadow" style="max-width:40%;">
            <div class="card-body">
            	<p class="fs-3" class="card-title">Your Account Balance</p>
                <p class="card-text display-6 text-success">&#8377;<span id="balance">${amount}</span></p>
                <button type="button" class='btn btn-primary' onclick="history.back()">Back Home</button>
            </div>
        </div>
    </div>
   </div> 
    <%@ include file="../../reusable-code/footer.jsp" %>
</body>
</html>
