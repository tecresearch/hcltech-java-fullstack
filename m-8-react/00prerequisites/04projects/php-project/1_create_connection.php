<?php

    // waySQL Database
//1. MYSQLi extension->its work with mysql database
//PDO->if you want to use different databases 
//get required information to connect with the server 
   if($_SERVER['REQUEST_METHOD']=='POST'){
    $servername=$_POST['servername'];
    $username=$_PoST['username'];
    $password=$_POST['password'];
    //or
      // $servername="localhost";
        // $username="";
        // $password="";

    echo "Your Server ,Username and Password".$servername. " " .$username." ".$password."Submited successfully <br/>";


        // connecting to the server 
     
        //create a connection object
        $conn = mysqli_connect($servername,$username,$password);

        //check the database connection
        if($conn){
            echo "Connection was successful configured <br>";
        }
        else{
           
            die("Sorry we failed to connect: ". mysqli_connect_error());
        }
} 
  
   
?>