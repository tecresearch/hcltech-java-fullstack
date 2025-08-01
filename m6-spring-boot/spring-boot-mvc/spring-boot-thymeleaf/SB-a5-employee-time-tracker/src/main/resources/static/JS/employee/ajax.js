import { loadEmployeeDelete } from './empdelete.js';
import { loadEmployeeEdit } from './empedit.js';
import { popupAddDepartment, popupRole } from './emppopup.js';
import { loadEmployeeList } from './emplist.js';
$(document).ready(function() {
	$("#loadDeleteEmployee").click(function() {
		loadEmployeeDelete();
	});
	$("#loadEditEmployee").click(function() {
		loadEmployeeEdit();
	});
	$("#addEmployee").click(function() {
		popupAddDepartment();
	});
	$("#addEmployee1").click(function() {
		popupAddDepartment();
	});
	$("#department").change(function() {
		alert($(this).val());
		popupRole($(this).val(), "role");
	});
	$("#edepartment").change(function() {
		popupRole($(this).val(), "erole");
	});
	$("#listEmployee").click(function() {
		loadEmployeeList();
	});
});
