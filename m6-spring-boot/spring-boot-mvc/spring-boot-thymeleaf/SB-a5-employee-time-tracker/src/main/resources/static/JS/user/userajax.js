import { popupEmployeeInName,popupEmployeeOutName } from './namepopup.js';
$(document).ready(function() {
	$("#recordTimeOut").click(function() {
		popupEmployeeInName()
	});
	$("#recordTimeIn").click(function() {
			popupEmployeeOutName()
	});
});