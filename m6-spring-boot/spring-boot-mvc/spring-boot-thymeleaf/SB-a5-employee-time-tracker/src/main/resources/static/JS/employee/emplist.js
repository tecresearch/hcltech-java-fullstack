export function loadEmployeeList() {
	$.ajax({
		url: "/employee-timetracker/admin/employee/get-employee-list",
		type: "GET",
		success: function(response) {
			let tableBody=$("#employeeList tbody");
			tableBody.empty();
			response.forEach(item=>{
				let row=`<tr>
				   <td>${item.empId}</td>
				   <td>${item.firstname}</td>
				   <td>${item.lastname}</td>
				   <td>${item.email}</td>
				   <td>${item.phone}</td>
				   <td><a href="#">${item.deptId}</a></td>
				   <td><a href="#">${item.roleId}</a></td>
				   <td>${item.timein}</td>
				   <td>${item.timeout}</td>
				</tr>`;
				tableBody.append(row);
			});
		},
		error: function() {
			console.error("AJAX Error: " + error);
		}
	});
}
