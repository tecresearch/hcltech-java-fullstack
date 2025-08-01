export function popupEmployeeInName() {
	$.ajax({
		url: "/employee-timetracker/user/time/employee-inlist", 
		type: "GET",
		success: function(response) {
				let deptDropdown = $("#inEmpId");
			deptDropdown.empty();
			for (let key in response) {
				deptDropdown.append('<option value="' + key + '">' + response[key] + '('+key+')</option>')
			}
		},
		error: function() {
			console.error("AJAX Error:", error);
		}
	});
}
export function popupEmployeeOutName() {
	$.ajax({
		url: "/employee-timetracker/user/time/employee-outlist", 
		type: "GET",
		success: function(response) {
				let deptDropdown = $("#outEmpId");
			deptDropdown.empty();
			for (let key in response) {
				deptDropdown.append('<option value="' + key + '">' + response[key] + '('+key+')</option>')
			}
		},
		error: function() {
			console.error("AJAX Error:", error);
		}
	});
}

