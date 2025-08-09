<!-- connecting database  -->
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

            $tbname=$_POST['create_tb'];
            $id=$_POST['insert_data'];
       
            echo "Your $tbname and $id Submited successfully <br/>";
                    //Delete the data from named database learn_php and table login



                    $sql="DELETE FROM `$tbname` WHERE `$tbname`.`id` = $id;";

                    $result=mysqli_query($conn,$sql);

                    if($result){
                        echo "Record has been deleted successfully <br/>";
                    }else{
                        echo "Record was not deleted";
                    }
        }

}
?>

