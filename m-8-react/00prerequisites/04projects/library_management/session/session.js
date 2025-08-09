  // Ensure user is logged in
  const loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));

  if (!loggedInUser) {
      // Redirect to login page if no user is logged in
      window.location.href = "index.html";
  } else {
      document.querySelector('h2').textContent = `Welcome, ${loggedInUser.username}`;
  }

  // Handle logout
  document.getElementById('logoutBtn').addEventListener('click', function() {
      localStorage.removeItem('loggedInUser');
      window.location.href = 'index.html';
  });
