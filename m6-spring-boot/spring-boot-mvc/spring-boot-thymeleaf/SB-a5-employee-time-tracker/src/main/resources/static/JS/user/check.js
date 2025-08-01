function checkUserExistense() 
{
		$.ajax(
		{
			url: "/employee-timetracker/admin/user/get-user?username=" + document.getElementById("username").value,
			type: "GET",
			success: function(response) 
			{
				if (response) 
				{
					document.getElementById("userExistMessage").innerHTML = "User name alerady exist";
					return false;
				}
			},
			error: function() 
			{
				console.error("AJAX Error: " + error);
			}
		});
	return true;
  }