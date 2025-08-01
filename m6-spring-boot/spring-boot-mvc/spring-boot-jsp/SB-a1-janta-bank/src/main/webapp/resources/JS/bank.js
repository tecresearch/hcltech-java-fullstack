function matchPassword() {

	if (document.getElementById("rpassword").value != document.getElementById("password").value) {
		alert("Repeat password doen not match with password")
		return false;
	}
	return true;
}
function validatePassword() {
	var password = document.getElementById("password").value;
	var pattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$/;
	var message = document.getElementById("message");

	if (!pattern.test(password)) {
		message.style.color = "red";
		message.innerHTML = "Password must be at least 8 characters long and include uppercase, lowercase, a number, and a special character.";
		return false;
	} else {
		message.style.color = "green";
		message.innerHTML = "Strong password!";
		return true;
	}
}
function validatePasswordMatch() {
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("rpassword").value;
	var message = document.getElementById("matchMessage");

	if (confirmPassword.length > 0) {
		if (password === confirmPassword) {
			message.style.color = "green";
			message.innerHTML = "Passwords match!";
		} else {
			message.style.color = "red";
			message.innerHTML = "Passwords do not match!";
		}
	} else {
		message.innerHTML = "";
	}
}
function validateEmail() {
	var email = document.getElementById("email").value;
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	var message = document.getElementById("emailMessage");

	if (emailPattern.test(email)) {
		message.style.color = "green";
		message.innerHTML = "Valid email!";
	} else {
		message.style.color = "red";
		message.innerHTML = "Invalid email format!";
	}
}