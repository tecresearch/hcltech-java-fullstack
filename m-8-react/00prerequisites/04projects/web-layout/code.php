<?php
$name=$_POST['name'];
//echo $name;
$gender=$_POST['a'];
$email=$_POST['email'];
$pass=$_POST['pass'];
$mobile=$_POST['mob'];
$city=$_POST['city'];
$address=$_POST['address'];
// connection code
$con=mysqli_connect('localhost','root','','gniot');
$query="insert into tbl_user(name,email,password,mobile,gender,city,address,status,dor) values ('$name','$email','$pass','$mobile','$gender','$city','$address','N',curdate())";
mysqli_query($con,$query);
echo "Record inserted Sucessfully";

?>









