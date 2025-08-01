<%@ include file="../../reusable-code/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
 th,td{
  text-align: left;
 }
 .scrollit {
    overflow:scroll;
    max-height:45vh;
}
.scrollit thead th {
      position: sticky;
      background:teal;
      color:white;
      top: 0;
}
</style>
<body class="bg-light text-center">
  <div class='bg-image'>
   <div class="container py-1">
        <div class="card mx-auto shadow" style="max-width:100%;">
            <div class="card-body" style="height:23vw">
            	<div class="table scrollit">
            		<table class="table table-bordered">
            		  <thead>
            		   <tr>
            		    <th>S.No</th><th>From Account</th><th>To Account</th>
            		    <th>Amount</th><th>Date</th><th>Time</th><th>Type</th>
            		   </tr>
            		  </thead>
            		  <tbody>
            		    <c:forEach var="tr" items="${tlist}" varStatus="loop">
            		      <tr>
            		       <td>${loop.index+1}</td>
            		       <td>${tr.fromaccount}</td>
            		       <td>${tr.toaccount==tr.fromaccount?"Self":tr.toaccount}</td>
            		       <td class='${tr.type=="Credit"?"text-success":"text-danger"}'>&#8377;${tr.amount}</td>
            		       <td>${tr.date}</td>
            		       <td>${tr.time}</td>
            		       <td class='${tr.type=="Credit"?"text-success":"text-danger"}'>${tr.type}</td>
            		      </tr>
            		    </c:forEach>
            		  </tbody>
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
