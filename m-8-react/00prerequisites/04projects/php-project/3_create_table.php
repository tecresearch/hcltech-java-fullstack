<?php

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
    echo "Connection was successful configured <br>";

    //get required information to connect with the server 

    if($_SERVER['REQUEST_METHOD']=='POST'){

        $dbname=$_POST['create_db'];
        $tbname=$_POST['create_tb'];

        echo "Your $dbname and $tbname Submited successfully <br/>";
            // create table in database
            $sql= "CREATE TABLE `$dbname`.`$tbname` ( `id` INT(3) NOT NULL AUTO_INCREMENT , `username` VARCHAR(11) NOT NULL , `password` INT(8) NOT NULL , PRIMARY KEY (`id`))";
            $result=mysqli_query($conn,$sql);

            // check for the database creation success
            if($result){
                echo "The Table was created succesfully <br>";
            }else{
                echo ("Table was not created succesfully because of error---". mysqli_connect_error($conn));
                
            }
    }
}
?>