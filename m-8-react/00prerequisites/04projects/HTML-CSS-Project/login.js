//Now making a funtion 
var objUser = [


    {
        username: "Brijesh",
        password: "Admin"
    },
    {
        username: "CV-Mr.Brijesh",
        password: "Admin"
    },
    {
        username: "Shivam",
        password: "Admin"
    },
    {
        username: "Jacks",
        password: "Admin"
    }

]

        alert(` Test Username: ${objUser[0].username} and Test Password: ${objUser[0].password}`);
 
function getInfoMe(){
    
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    for ( var i = 0; i <objUser.length; i++) {

        if (username == objUser[i].username && password == objUser[i].password){

            alert(username + " is successfully logged in");
            window.location.href="home.html";
            return        }
          
    }
    alert("Invalid credentials.....");
}
