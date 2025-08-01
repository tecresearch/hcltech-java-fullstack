<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Home Page</title>
    <link href="/janta-bank/resources/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="/janta-bank/resources/CSS/bank.css?v=2.0" rel="stylesheet">
    <script type="text/javascript" src="/janta-bank/resources/JS/bootstrap.bundle.min.js?v=2.0"></script>
<script>
/*let timeout;
function resetTimer() {
    clearTimeout(timeout);
    timeout = setTimeout(logoutUser, 20 * 1000); // seconds
}
function logoutUser() {
    alert("Your session has expired due to inactivity. You will be logged out.");
    window.location.href = "/janta-bank/sessionExpired"; // Redirect to session expired page
}
// Detect user activity
window.onload = resetTimer;
document.onmousemove = resetTimer;
document.onkeypress = resetTimer;
document.onclick = resetTimer;
document.onscroll = resetTimer;*/
</script>
</head>
<div class="header">
	<div class="row">
		<div class='col-3'>
			<span class='fs-5 text-info'>Savings Account</span><br> <span
				class='fs-6' th:text="${session.accountno}"></span>
		</div>
		<div class='col-3'>
			<p class='fs-3'>Janta Bank</p>
		</div>
		<div class='col-3'>
			<span class='fs-5 text-info'>Your Name</span><br> <span
				class='fs-6' th:text="${session.username}"></span>
		</div>
		<div class='col-3'>
			<a href="/janta-bank/logout.do" class='fs-6 text-info'>Logout</a>
		</div>
	</div>
</div>