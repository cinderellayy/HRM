<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>HRM</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		 <link rel="stylesheet" href="dist/css/bootstrap.css" />
	 
		<link rel="stylesheet" type="text/css" href="css/style.css">
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
  <!-- Default panel contents -->
  <div class="panel-heading">Please enter the department information</div>
		<form name="form1" class="form-group" method="post" action="UpdateDeptServlet">
			<table class="table table-bordered">
				
				<tr>
					<td  >
						Department number
					</td>
					<td >
						<input name="deptName"  class="form-control"  type="text" id="deptName" value="${dept.deptName}">
					</td>
				</tr>
				<tr>
					<td >
						Department address
					</td>
					<td >
						<input name="deptLoc"  class="form-control" type="text" id="deptLoc" value="${dept.deptLoc}">
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" >
						<input  class="btn " type="submit" name="Submit" value="SUBMIT"> &nbsp;
						<input  class="btn" type="button" name="Submit2" value="CANAEL" onclick="history.back();">
						<input type="hidden" name="deptId" value="${dept.deptId}">
					</td>
				</tr>
			</table>
		</form>
		<br>
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
							<a target="_blank" href="#">Home</a>
							<a href="#">Contact</a>
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
