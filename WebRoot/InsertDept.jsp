<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>InsertDept</title>
	<link rel="stylesheet" href="dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript">
			/*验证表单*/
			function checkForm() {				
				var deptName = document.form1.deptName;
				
				if (deptName.value == '' || deptName.value.length>5) {
					alert('Department name cannot be empty and a maximum of 5 characters!');
					deptName.focus();
					return false;
				}
				
				var deptLoc = document.form1.deptLoc;
				
				if (deptLoc.value == '' || deptLoc.value.length>20) {
					alert('Department address cannot be empty and a maximum of 20 characters!');
					deptLoc.focus();
					return false;
				}
				
				return true;
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
        
	</style>
	</head>

	<body class="container">
	<div class="panel panel-default ">

	<div class="panel-heading">Please enter the dept information</div>

		<form  class="form-group"name="form1" method="post" action="InsertDeptServlet" onsubmit="return checkForm();">
			<table class="table_border table" >
				
				<tr>
					<td >
						Dept Name
					</td>
					<td >
						<input class="form-control" name="deptName" type="text" id="deptName">
					</td>
				</tr>
				<tr>
					<td>
					   Dept Loc
					</td>
					<td height="24">
						<input class="form-control" name="deptLoc" type="text" id="deptLoc">
					</td>
				</tr>
				<tr align="center">
					<td height="24" colspan="2">
						<input type="submit" class="btn" name="Submit" value="Submit">
						<input type="button"  class="btn" name="Submit2" value="Reset" onclick="history.back();">
					</td>
				</tr>
			</table>
		</form>
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
</html>
