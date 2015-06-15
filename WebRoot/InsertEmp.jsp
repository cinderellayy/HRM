<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>InsertEmp</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" href="dist/css/bootstrap.css" />
	    <link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		
		<script type="text/javascript">
			/*验证表单*/
			function checkForm() {				
				var empName = document.form1.empName;
				
				if (empName.value == '' || empName.value.length>6) {
					alert('员工姓名不能为空且最多6字符');
					empName.focus();
					return false;
				}
				
				var empEmail = document.form1.empEmail;
				
				if (empEmail.value == '' || empEmail.value.length>30) {
					alert('邮箱地址不能为空且最多30字符');
					empEmail.focus();
					return false;
				}
				
				return true;
			}
			
			function change(){
				var name = document.getElementById("1").value;		
				var id_min = name;
				var id_max = name+"+max";
				document.getElementById("jobMinSalary").value = document.getElementById(id_min).value;
				document.getElementById("jobMaxSalary").value = document.getElementById(id_max).value;
				
			}
			function changedept() {
				
			}
		
		</script>
		  <style>
	    body{
		background:url("./img/bg1.jpg") repeat;
		font-family:"微软雅黑";
		 font-size: medium;
		
	     }
	     .panel{
	     	margin-top: 6%		;
	     	  text-align:center;
	     
	     }
	     .container{
	     width:53%;}
	     .form-control{
	     width:40%;}
	 .table > tbody > tr > td{
	     vertical-align: middle;
         font-size: medium;
         text-align:center;
         }
         .footer{
         margin-top:30%;
         }
         .dropdown-toggle{
         border-color: gainsboro;float:left;}
        .width{
        width:30px;}
        .dropdown-toggle{
        width:40%;}
	</style>
	</head>

	<body class="container">
	<div class="panel panel-default ">

	<div class="panel-heading">Please enter the employee information</div>
	
		<form name="form1" class="form-group" method="post" action="InsertEmpServlet" onsubmit="return checkForm();">
			<table class="table_border table" >
				
				<tr>
					<td >Employee Name
					
					</td>
					<td >
						<input class="form-control" name="empName" type="text" id="empName">
					</td>
				</tr>
				<tr>
					<td>Employee Email
					
					</td>
					<td>
						<input class="form-control"name="empEmail" type="text" id="empEmail">
					</td>
				</tr>
				<tr>
					<td>Employee Phone
					
					</td>
					<td >
						<input class="form-control"  name="empPhone" type="text" id="empPhone">
					</td>
				</tr>
				<tr>
					<td>Employee Hiredate
						
					</td>
					<td >
						<input class="form-control" name="empHiredate" type="text" id="empHiredate" onclick="WdatePicker()"  >
				</tr>
				<tr>
					<td>Job Id
						
					</td>
					
					<td>		
						<select  class="btn dropdown-toggle" id="1" name="jobId" onchange="change()">
						<c:forEach items="${list}" var="job">
							<option id="${job.jobId}" value="${job.jobName}">${job.jobName}</option>		
						</c:forEach>
						</select>
					
						<c:forEach items="${list}" var="job">
							<input id="${job.jobName}" value="${job.jobMinSalary}" type="hidden"/>
							<input id="${job.jobName}+max" value="${job.jobMaxSalary}" type="hidden"/>
						</c:forEach>
					
					    Salary 
						 <input  style = "width:50px" name="jobMinSalary" type="text" id="jobMinSalary"> -
						 <input style = "width:50px" name="jobMaxSalary" type="text" id="jobMaxSalary">		
					</td>
				</tr>
				
				<tr>
					<td >Employee Salary
						 
					</td>
					<td>
						<input class="form-control" name="empSalary" type="text" id="empSalary">
					</td>
				</tr>
				<tr>
					<td>Dept Name
						
					</td>
					<td>
					 <select  class="btn dropdown-toggle" name="deptName" id="2" onchange="changedept()">			
						   <c:forEach items="${list_dept}" var="dept">
				     			 <option id="${dept.deptId}" value="${dept.deptName}">${dept.deptName}</option>
				     			 	
						   </c:forEach>
					</select>
					</td>
				</tr>
				<tr align="center">
					<td height="24" colspan="2">
						<input  class="btn" type="submit" name="Submit" value="Submit">
						<input  class="btn" type="button" name="Submit2" value="Reset" onclick="history.back();">
					</td>
				</tr>
			</table>
		</form>
	</div>
	</div>
			<div class="section-divider-a m-hide footer">
				<div class="section-divider-inner large-h2">
					<h2>HRM</h2>
				</div>
			</div>
			<div class="inner-wrap">
				<div class="inner">
					<div class="footer-links">
						<p class="p1">
							<a target="_blank" href="index.jsp">Home</a>
							
							<a target="_blank" href="#">Dept</a>
							<a target="_blank" href="#">Job</a>
							<a target="_blank" href="#">Login</a>
							<a target="_blank" href="#">Exit</a>
						</p>
						<span class="copyright">© 2015 - By Class Three Number One Team</span>
					</div>
				</div>

			</div>
			<p class="pull-right"><a href="#"><i class="glyphicon glyphicon-plane"></i></a></p>
		</div>
	</body>
	<script src="./Date/WdatePicker.js"></script>
</html>
