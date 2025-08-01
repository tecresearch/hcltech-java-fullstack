<%@ include file="../../reusable-code/header.jsp" %>
<body class="bg-light text-center">
  <div class='bg-image'>
   <div class="container py-5">
        <div class="card mx-auto shadow" style="max-width:40%;">
            <div class="card-body py-3">
            	<p class='fs-3 py-0 text-primary'>Withdraw Form</p>
            	<p><input type="number" class="form-control" name="amount" placeholder="Enter Amount"></p>
                <button class='btn btn-primary'>Submit</button>
                <button type="button" class='btn btn-secondary' onclick="history.back()">Back Home</button>
            </div>
        </div>
    </div>
   </div> 
    <%@ include file="../../reusable-code/footer.jsp" %>
</body>
</html>
