document.getElementById("logoutBtn").addEventListener("click", function() {
    // Remove user session from Local Storage
    localStorage.removeItem("loggedInUser");

    // Redirect to the login page
    window.location.href = "index.html";
});
