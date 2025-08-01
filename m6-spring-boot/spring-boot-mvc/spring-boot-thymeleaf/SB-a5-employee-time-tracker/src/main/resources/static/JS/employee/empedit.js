import { popupEditDepartment,popupRole} from './emppopup.js'; 
export function loadEmployeeEdit() {
	$.ajax({
		url: "/employee-timetracker/admin/employee/get-employee-edit?eid=" + document.getElementById("editEid").value,
		type: "GET",
		success: function(response) {
			if (response.msg != null) {
				document.getElementById("employeeEditDetails").style.display = "none";
				alert(response.msg);
			}
			else {
				document.getElementById("employeeEditDetails").style.display = "block";
				popupEditDepartment(response["department"],response["role"]);
				for (let key in response) {
					if(key!="department")
						document.getElementById(key).value = response[key];
				}
				//popupRole(document.getElementById("edepartment").value,"erole");
			}
		},
		error: function() {
			console.error("AJAX Error: " + error);
		}
	});
}