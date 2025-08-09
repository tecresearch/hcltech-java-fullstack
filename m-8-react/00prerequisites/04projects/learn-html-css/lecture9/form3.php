<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complex From3</title>
</head>
<body>
    <fieldset>
        <legend><h1>Complex Form</h1></legend>
        <br><br>
        <fieldset>
            <legend>Personal Informations</legend>
            <label for="name">Name</label>
            <input type="email" name="email" id="email">
            <label for="phone">Phone</label>
            <input type="tel" name="phone" id="phone">
            <label for="dob">Date of Birth</label>
            <input type="date" name="dob" id="dob">
            <label for="male">Gender</label>
            <input type="radio" name="gender" id="male">
            <label for="male">Male</label>
            <input type="radio" name="gender" id="female">
            <label for="female">Female</label>
            <label for="country">Country</label>
            <select name="country" id="country">
                <option value="default">--choose--</option>
                <option value="India">India</option>
                <option value="US">US</option>
                <option value="China">China</option>
                <option value="Ingland">Ingland</option>
            </select>
        </fieldset>
       
        <fieldset>
            <legend>
                <label for="street">Address Street</label>
                <input type="text" name="street" id="street">
                <label for="city">City</label>
                <input type="text" name="city" id="city">
                <label for="state">State</label>
                <input type="text" name="state" id="state">
                <label for="zipcode">Zipcode</label>
                <input type="text" name="zipcode" id="zipcode">
             </legend>
        </fieldset>
        <br>
        <fieldset>
            <legend>Other Informations</legend>

            <textarea name="otherinfo" id="comment" cols="30" rows="10">Comments</textarea>
            <label for="agree">I agree to the terms of service</label>
            <input type="checkbox" name="agree" id="agree">

        </fieldset>
        <br>
        <input type="submit" value="Submit">
    </fieldset>
</body>
</html>