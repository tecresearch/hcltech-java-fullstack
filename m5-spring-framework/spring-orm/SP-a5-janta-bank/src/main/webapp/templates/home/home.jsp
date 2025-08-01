<%@ include file="../reusable-code/header.jsp" %>
<body>
    <div class="nav">
        <a href="/janta-bank">Home</a>
        <a href="#">About Us</a>
        <div class="dropdown">
            <button class="bt dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
              Account Services
            </button>
            <ul class="ddm dropdown-menu" aria-labelledby="dropdownMenuButton1">
              <li><a class="dropdown-item" href="/janta-bank/services/view-balance">Show Balance</a></li>
              <li><a class="dropdown-item" href="/janta-bank/services/deposit-form">Deposit Money</a></li>
              <li><a class="dropdown-item" href="withdraw">Withdraw Money</a></li>
              <li><a class="dropdown-item" href="transfer">Transfer Money</a></li>
              <li><a class="dropdown-item" href="statements">View Statements</a></li>
            </ul>
          </div>
        <a href="#">Contact</a>
    </div>
    <div class="hero bg-image">
        <h2>Your Trusted Financial Partner</h2>
    </div>
    <%@ include file="../reusable-code/footer.jsp" %>
</body>
</html>