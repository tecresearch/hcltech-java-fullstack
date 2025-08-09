document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    // Simulating login verification (you can enhance this by connecting to a real backend)
    if ((username === "admin" && password === "admin123" && role === "admin") || 
        (username === "user" && password === "user123" && role === "user")) {

        // Save user session in Local Storage
        localStorage.setItem("loggedInUser", JSON.stringify({ username, role }));

        // Redirect based on role
        if (role === "admin") {
            window.location.href = "admin-dashboard.html";
        } else {
            window.location.href = "user-dashboard.html";
        }
    } else {
        document.getElementById("loginError").textContent = "Invalid credentials. Please try again.";
    }
});
