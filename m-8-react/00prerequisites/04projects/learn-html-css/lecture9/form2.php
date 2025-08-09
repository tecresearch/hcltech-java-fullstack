
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
    echo "Form2 connection was successful configured <br><br>";
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
    <title>Form2</title>
</head>
<body>
    <fieldset>
        <legend><h2>Job  Application</h2></legend>
  
        <label for="name">Name:</label><br>
        <input type="text" name="name" id="name"><br>
        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email"><br>
        <label for="tel">Phone:</label><br>
        <input type="phone" name="phone" id="phone"><br>
        <label for="resume">Resume</label><br>
        <input type="file" name="resume" id="resume"><br>
        <label for="experience">Experience(year)</label><br>
        <input type="number" name="counter" id="experience" min="0" max="50"><br>
        <fieldset>
            <legend>Skills</legend>
            <label for="html">HTML</label>
            <input type="checkbox" name="html" id="html">
            <label for="css">CSS</label>
            <input type="checkbox" name="css" id="css">
            <label for="js">Javascript</label>
            <input type="checkbox" name="js" id="js"><br>
        </fieldset>
            <label for="education">Highest Education</label><br>
            <select name="education" id="education">
                <option value="highschool"><p>10<sup>th</sup></p></option>
                <option value="Intermediate"><p>12<sup>th</sup></p></option>
                <option value="Graduation">Graduation</option>
            </select>
        <fieldset>
            <legend>Availability</legend>

            <label for="radio1">Full Time</label>
            <input type="radio" name="radio" id="radio1">
            <br>
            <label for="radio2">Part Time</label>
            <input type="radio" name="radio" id="radio2">
        
        </fieldset>
        
        <label for="comment">Additional Comments</label><br>
        <textarea name="comment" id="comment" cols="30" rows="10"></textarea><br>
        <input type="submit" value="Apply">


    </fieldset>
</body>
</html>