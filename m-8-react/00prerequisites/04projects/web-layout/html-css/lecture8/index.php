
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>
</head>
<body>
<fieldset disabled="disabled">
    <legend>Login Form</legend>
    <form action="#" >
         <label for="email">Enter Email ID:</label>
         <br>
        <input type="text" id="email" placeholder="Mrjacks@gmail.com">
        <br>
        <label for="password">Enter Password</label><br>
        <input type="text" id="password"  placeholder="password">
        <br>
        <input type="submit" value="Login">
       
    </form>
  
</fieldset>
<hr>
    <!-- Form Elements  
        input :taking input
        label:set the name to input
        select->dropdown
        option:choice
        button:button
        textArea:multiline input
        fieldset:to group all element
        legend:Caption
    -->
<fieldset >
    <legend>HTML form Dummy</legend>
    <br>
    <form >
        <label for="datepicker">Date Picker:</label><br><br>
        <input type="date" name="date" id="datepicker"><br><br>
        <label for="selector">Choose Dishes</label>
        <select name="selector" id="selector">
            <option value="maggi">Maggi</option>
            <option value="Kurakare">Kurakare</option>
            <option value="mango">Mango</option>
        </select><br><br>
        <button type="submit">Send</button><br><br>
        <textarea name="textfield2" id="textarea" cols="30" rows="10"></textarea>
    </form>
</fieldset>
    <hr> 

    <fieldset>
        <legend>INPUT TYPES</legend>
        <br>
        <form action="">
            <label for="textfield1">Type...</label>
            <input type="text" name="textfield1">
            <br>
            <label for="btn"></label><br><br>
            <input type="button" name="btn"id="btn"value="subscribe">
            <br><br>
            <select name="radioselect" id="radioselect">Radio</select><br><br>
            <input type="radio" name="rbtn1" id="r1">
            <input type="radio" name="rbtn2" id="r2">
            <input type="radio" name="rbtn3" id="r3">
            <input type="radio" name="rbtn4" id="r4">
            <label for="Hello">Checkbox</label><br><br>
            <input type="checkbox" name="Hello" id="Hello">
            <br><br>
            <label for="upload">upload</label>
            <input type="file" name="upload" id="upload">
            <br><br>
            
            <input type="image" name="imagebutton" src="Company.png" alt="Login" id="imgbtn" height="50px" width="100px">
            <label for="pass">Typepassword</label>
            <input type="password" name="password1" id="p1">
        </form>
    </fieldset>     

    <br><br>
    <hr>
    

</body>
</html>