<?php

    // waySQL Database
//1. MYSQLi extension->its work with mysql database
//PDO->if you want to use different databases 

// connecting to the database 
function connection(){

$servername="localhost";
$username="mrjacks";
$password="Mrjacks@engg";

//create a connection object
$conn = mysqli_connect($servername,$username,$password);

//check the database connection
if(!$conn){
    echo die("Sorry we failed to connect: ". mysqli_connect_error());
}
else{
    echo "Form1 connection was successful configured <br><br>";
}
}
connection();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form1</title>
</head>
<body>
    <fieldset>
        <legend>Event Registration</legend>
  <form action="">
  <label for="name">Name: </label>
    <input type="text" name="name" id="name"><br><br>
    <label for="emailid">Email Id: </label>
    <input type="email" name="emailid" id="emailid"><br><br>
    <label for="phone">phone: </label>
    <input type="tel" name="phone" id="phone"><br><br>
    <label for="occupation">occupation</label>
    <select name="occupation" id="occupation">
        <option value="Student">Student</option>
        <option value="Teacher">Teacher</option>
    </select><br><br>
    <fieldset>
        <legend>Topics of Interest</legend>
        <label for="html">HTML</label>
        <input type="checkbox" name="html" id="html" value="HTML">
        <label for="html">CSS</label>
        <input type="checkbox" name="css" id="css" value="CSS">
        <label for="html">Javascript</label>
        <input type="checkbox" name="js" id="js" value="javascript">
    </fieldset><br><br>
    <label for="comment">Comments:</label><br>
   <textarea name="comment" id="comment" cols="30" rows="10"></textarea><br><br>
    <input type="submit" value="Registration">
  </form>
    

    </fieldset>
</body>
</html>