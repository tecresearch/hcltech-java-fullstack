<?php


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Get Form</title>
</head>
<body>
<fieldset>
        <legend>Get Form</legend>
        <form action="get_method_form.php" method="get">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username"><br>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email"><br>
            <label for="password">Password</label>
            <input type="password" name="password" id="password"><br>
            <label for="phone">Phone</label>
            <input type="tel" name="phone" id="phone"><br>
            <label for="description">Description</label><br>
            <textarea name="description" id="" cols="30" rows="10"></textarea><br>
            <input type="submit" value="Register">
        </form>
    </fieldset>
</body>
</html>