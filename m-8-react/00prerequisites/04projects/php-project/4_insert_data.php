<?php
//connection with database
$severname="localhost";
$username="mrjacks";
$password="Mrjacks@engg";
if($_SERVER['REQUEST_METHOD']=='POST'){
$database=$_POST['create_db'];

    $conn=mysqli_connect($severname,$username,$password,$database);
    if(!$conn){
        die("Failed to connect".mysqli_connect_error());
    }
    echo "Connected successfully <br/>";


        if($_SERVER['REQUEST_METHOD']=='POST'){

            $user=$_POST['insert_data1'];
            $pass=$_POST['insert_data2'];
            $tbname=$_POST['create_tb'];
            echo "Your $user , $pass and $tbname Submited successfully <br/>";

                //insert the data in to named database learn_php and table login
                $sql="INSERT INTO `$tbname` (`username`, `password`) VALUES ('$user', '$pass')";
                $result=mysqli_query($conn,$sql);
                if($result){
                    echo"Record has been inserted successfully<br/>";
                }else{
                    echo"failed to insert the data";
                }
                echo"end";
        }
    }
?>