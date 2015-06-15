function InsertJob(adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	location.href='InsertJob.jsp';
}
function deleteJob(jobId,adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	var flag=window.confirm("Are you sure to delete this data？");
	if(flag) location.href='DeleteJobServlet?jobId='+jobId;
}
function updateJob(jobId,adminLevel){
	if(adminLevel==2){
		alert("Insufficient Permissions!");
		return false;
	}
	location.href='ToUpdateJobServlet?jobId='+jobId;
}
