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

        if($_SERVER['REQUEST_METHOD']=='POST'){

            $dbname=$_POST['create_db'];
            echo "Your $dbname Submited successfully <br/>";
            //Create a Database
            $sql = "CREATE DATABASE $dbname";
            $result=mysqli_query($conn,$sql);
            echo "The result is ";
            echo"<br>";
            echo var_dump($result);
            echo "<br>";

            //check for the database creation success
            if($result){
                echo "The DB was created succesfully <br>";
            }else{
                echo die("Database was not created succesfully because of error---". mysqli_connect_error($conn));
            }
        }
}
?>