<%@ include file="../../reusable-code/header.jsp" %>
<body class="bg-light text-center">
  <div class='bg-image'>
   <div class="container py-5">
        <div class="card mx-auto shadow ch" style="max-width:40%;">
            <div class="card-body py-5">
             <form action="deposit.do"> 
            	<p class='fs-3 py-0 text-primary'>Deposit Form</p>
            	<p><input type="number" value="${amount}" class="form-control text-center" name="amount" placeholder="Enter Amount"></p>
                <button class='btn btn-primary'>Submit</button>
                <button type="button" class='btn btn-secondary' onclick="history.back()">Back Home</button>
                <p class='my-2'><span class='text-success'>${msg}</span></p>
             </form>
            </div>
        </div>
    </div>
   </div> 
    <%@ include file="../../reusable-code/footer.jsp" %>
</body>
</html>
