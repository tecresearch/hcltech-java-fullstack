<%@ include file="../user-header.jsp" %>
<html>
  <body>
  <div class="bg bg-image">
    <div class="container d-flex justify-content-center align-items-center py-1">
    <div class="card p-4 shadow-lg" style="width: 40%;height: 70%;">
        <h4 class="text-center mb-4">Login</h4>
        <form action="authenticate-user" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">User Id</label>
                <input type="text" value="${uid}" class="form-control" name="userid" placeholder="Enter user id" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
            </div>
            <div class="mb-3 my-4">
                <p><button class="btn btn-primary w-100">Login</button></p>
            </div>
        </form>
        <div class="text-center mb-3">
            <a href="registration">Register User?</a>
        </div>
        <div class='text-center'>
          <label class='text-danger'>${msg}</label>
        </div>
     </div>
    </div>
   </div>
   <%@ include file="../../reusable-code/footer.jsp" %>
  </body>
</html>