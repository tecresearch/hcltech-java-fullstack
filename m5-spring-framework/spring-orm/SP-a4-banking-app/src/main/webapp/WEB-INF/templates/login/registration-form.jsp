<html>
<head>
  <script src="/banking-app/resources/JS/script.js"></script>
  <link href='/banking-app/resources/CSS/style.css' rel='stylesheet'>
  <link href='/banking-app/resources/CSS/bootstrap.min.css' rel='stylesheet'>
</head>
<body class='bgi'>
 <div class='dvv'>
   <label class='lah'  style='color:white;text-decoration:underline;font-size:2.5vw'>User Registration</label>
  </div>
  <hr>
  <div class="col-6 mx-auto my-3">
    <div class='card'> 
     <div class='card-body'>
     <form action="register-user" method="post">
      <div class='row'>
       <div class="col-12">
       	<label for="userid">User Id</label>
       	<input type="text" class='form-control' name='userid' id='userid' required>
       </div>
      </div>
      <div class='row my-3'>
       <div class="col-6">
       	<label for="password">Password</label>
       	<input type="password" class='form-control' name='password' id='password' required>
       </div>
       <div class="col-6">
       	<label for="rpassword">Repeat Password</label>
       	<input type="password" class='form-control' name='rpassword' id='rpassword' required>
       </div>
      </div>
      <div class='row my-3'>
       <div class="col-6">
       	<label for="firstname">First name</label>
       	<input type="text" class='form-control' name='firstname' id='firstname' required>
       </div>
       <div class="col-6">
       	<label for="lastname">Last name</label>
       	<input type="text" class='form-control' name='lastname' id='lastname' required>
       </div>
      </div>
      <div class='row my-3'>
       <div class="col-6">
       	<label for="phone">Phone number</label>
       	<input type="text" class='form-control' name='phone' id='phone' required>
       </div>
       <div class="col-6">
       	<label for="email">Email id</label>
       	<input type="text" class='form-control' name='email' id='email' required>
       </div>
      </div>
      <div class='row my-3'>
       <div class="col-6">
       	<label for="address">Address</label>
       	<input type="text" class='form-control' name='address' id='address' required>
       </div>
       <div class="col-6">
       	<label for="dob">Date of Birth</label>
       	<input type="date" class='form-control' name='dob' id='dob' required>
       </div>
      </div>
      <div class='row my-3'>
       <div class="col-12 text-end">
       	<button class='btn btn-primary'>Register User</button>
       	<input type="button" value='Cancel' class='btn btn-secondary' onclick="history.back()">
       </div>
      </div>
     </form>
     </div>
    </div>
  </div>
</body>
</html>