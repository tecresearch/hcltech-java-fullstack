<?php

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post Form</title>
</head>
<body>
  
    <br>
    <fieldset>
        <legend>Post Form</legend>
        <form action="post_method_form.php" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username"><br>
            <label for="password">Password</label>
            <input type="password" name="password" id="password"><br>
            <input type="submit" value="Login">
        </form>
    </fieldset>
</body>
</html>