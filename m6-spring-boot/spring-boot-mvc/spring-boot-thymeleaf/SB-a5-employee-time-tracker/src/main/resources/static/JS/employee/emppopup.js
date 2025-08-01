export function popupAddDepartment() {
	$.ajax({
		url: "/employee-timetracker/admin/employee/department-list", 
		type: "GET",
		success: function(response) {
			let deptDropdown = $("#department");
			deptDropdown.empty();
			for (let key in response) {
				deptDropdown.append('<option value="' + key + '">' + response[key] + '</option>')
			}
			popupRole(document.getElementById("department").options[0].value,"role");
		},
		error: function() {
			console.error("AJAX Error:", error);
		}
	});
}
export function popupEditDepartment(deptId,roleId) {
	$.ajax({
		url: "/employee-timetracker/admin/employee/department-list", 
		type: "GET",
		success: function(response) {
			let deptDropdown = $("#edepartment");
			deptDropdown.empty();
			//deptDropdown.append('<option value="-1">Choose Department</option>')
			for (let key in response) {
				if(deptId==key)
					deptDropdown.append('<option selected="selected" value="' + key + '">' + response[key] + '</option>');	
				else
					deptDropdown.append('<option value="' + key + '">' + response[key] + '</option>');	
			}
			popupRole1(deptId,"erole",roleId);
		},
		error: function() {
			console.error("AJAX Error:", error);
		}
	});
}
export function popupRole(deptId,role) {
	let roleDropDown = $("#"+role);
	$.ajax({
		url: "/employee-timetracker/admin/employee/role-list?deptId=" + deptId,
		type: "GET",
		success: function(response) {
			roleDropDown.empty();
			for (let key in response) {
				roleDropDown.append('<option value="' + key + '">' + response[key] + '</option>')
			}
		},
		error: function() {
			console.error("AJAX Error:", error);
		}
	});
}
export function popupRole1(deptId,role,roleId) {
	let roleDropDown = $("#"+role);
	$.ajax({
		url: "/employee-timetracker/admin/employee/role-list?deptId=" + deptId,
		type: "GET",
		success: function(response) {
			roleDropDown.empty();
			for (let key in response) {
				if(roleId==key)
					roleDropDown.append('<option selected value="' + key + '">' + response[key] + '</option>')
				else
					roleDropDown.append('<option value="' + key + '">' + response[key] + '</option>');
			}
		},
		error: function() {
			console.error("AJAX Error:", error);
		}
	});
}
