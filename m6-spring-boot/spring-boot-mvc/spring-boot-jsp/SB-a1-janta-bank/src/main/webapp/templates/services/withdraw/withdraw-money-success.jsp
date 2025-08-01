<%@ include file="../../reusable-code/header.jsp" %>
<style>
 th,td{
  text-align: left;
 }
</style>
<script type="text/javascript">
document.addEventListener("keydown", function (event) {
    if (event.key === "F5" || (event.ctrlKey && event.key === "r")) {
        event.preventDefault();
    }
});
window.onload = function () {
    if (performance.navigation.type === 1) {
    	event.preventDefault();
    }
};
</script>
<body class="bg-light text-center">
  <div class='bg-image'>
   <div class="container py-1">
   		<div>
           <label class='fs-3 text-white text-decoration-underline'>Withdraw Money Success</label>
        </div>
        <div class="card mx-auto shadow" style="max-width:50%;">
            <div class="card-body">
            	<div class="table">
            		<table class="table table-bordered">
            		  <tr>
            		    <th>Transaction Id</th>
            		    <td>${transaction.tid}</td>
            		  </tr>	
            		  <tr>
            		    <th>From Account</th>
            		    <td>${transaction.fromaccount}</td>
            		  </tr>
            		  <tr>
            		    <th>To Account</th>
            		    <td>Self</td>
            		  </tr>
            		  <tr>
            		    <th>Account holder</th>
            		    <td>${sessionScope.username}</td>
            		  </tr>
            		  <tr>
            		    <th>Amount</th>
            		    <td class="text-danger">&#8377;${transaction.amount}</td>
            		  </tr>
            		  <tr>
            		    <th>Date and Time</th>
            		    <td><span>${transaction.date}</span><span style='margin-left:4px'>${transaction.time}</span></td>
            		  </tr>
            		  <tr>
            		    <th>Transaction Type</th>
            		    <td class="text-danger">${transaction.type}</td>
            		  </tr>
            		</table>	
            	</div>
            </div>
        </div>
    </div>
    <div>
     <a href="/janta-bank" class='btn btn-primary'>Back Home</a>
     <a href="/janta-bank" class='btn btn-secondary'>Download Receipt</a>
    </div>
   </div> 
    <%@ include file="../../reusable-code/footer.jsp" %>
</body>
</html>
