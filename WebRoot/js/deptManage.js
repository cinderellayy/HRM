function InsertDept(adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	location.href='InsertDept.jsp';
}
function deleteDept(deptId,adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	var flag=window.confirm("Are you sure to delete this data？");
	if(flag) location.href='DeleteDeptServlet?deptId='+deptId;
}
function updateDept(deptId,adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	location.href='ToUpdateDeptServlet?deptId='+deptId;
}
