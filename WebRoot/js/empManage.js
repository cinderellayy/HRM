function InsertEmp(adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	location.href='JumpServlet';
}
function deleteEmp(empId,adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	var flag=window.confirm("Are you sure to delete this data？");
	if(flag) location.href='DeleteEmpServlet?empId='+empId;
}
function updateEmp(empId,adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	location.href='ToUpdateEmpServlet?empId='+empId;
}
