<?php
$e=$_POST['e'];
$p=$_POST['p'];
$con=mysqli_connect('localhost','root','','gniot');
$query="select * from tbl_user where email='$e' and password='$p'";
$res=mysqli_query($con,$query);
if($row=mysqli_fetch_array($res))
{
	header("Location:profile.php");
}
else
{
	header("Location:login.php");
}
?>



