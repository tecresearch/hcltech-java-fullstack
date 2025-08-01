export function loadEmployeeDelete() {
	$.ajax({
		url: "/employee-timetracker/admin/employee/get-employee-delete?eid=" + document.getElementById("deleteEid").value,
		type: "GET",
		success: function(response) {
			if (response.msg != null) {
				alert(response.msg);
			}
			else {
				document.getElementById("employeeDeleteDetails").style.display = "block";
				alert(response.department);
				for (let key in response) {
					document.getElementById("lbl"+key).innerHTML = response[key];
				}
			}
		},
		error: function() {
			console.error("AJAX Error: " + error);
		}
	});
}
//window.loadEmployeeDelete = loadEmployeeDelete; 