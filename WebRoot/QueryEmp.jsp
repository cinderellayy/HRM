<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>HRM</title>
	<link rel="stylesheet" href="./dist/css/bootstrap.css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" media="all" href="./css/index.css">
	<style>
	body{
		background:url("./img/bg1.jpg") repeat;
	}

		
   .p1{
   	margin-left: 33px;
   	 }
   	.nav-inner{
   		font-family: "微软雅黑";
   	}
   	table{
   	color:#333;
   	}
 .color{
 color:#333;}
  .copyright{
 
 margin-left:22%;}
 .table > thead > tr > th, 
 .table > tbody > tr > th, 
 .table > tfoot > tr > th, 
 .table > thead > tr > td, 
 .table > tbody > tr > td, 
 .table > tfoot > tr > td{
 padding:1px;}
</style>
</head>
<body class="home page page-id-4 page-template-default" style="">
	<div class="overflow-wrap">
		<!-- Start Overflow Wrap -->

		<div class="stage">
			<!-- Start Stage -->
			<header class="">
				<div class="inner-wrap">
					<div class="inner">
						<nav class="full-margin">
							<div class="nav-inner">
								<div class="menu-main-nav-left-container">
									<ul class="nav-left">
										<li id="menu-item-22" class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-4 current_page_item menu-item-22 nav-left">
											<h3>HRM</h3>
										</li>
										<li id="menu-item-22" class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-4 current_page_item menu-item-22">
											<a href="index.jsp">Home</a>
										</li>
										<li id="menu-item-21" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-21">
											<a href="QueryDeptServlet">Dept</a>
										</li>
										<li id="menu-item-20" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-20">
											<a href="QueryJobServlet">Job</a>
										</li>
										<li id="menu-item-19" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-19">
											<a href="QueryEmpServlet">Employee</a>
										</li>
									</ul>
								</div>
								<div class="menu-main-nav-right-container">
									<ul class="nav-right">
										<li id="menu-item-24" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-24">
											<a href="login.jsp">Login</a>
										</li>
										<li id="menu-item-23" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-23">
											<a href="login.jsp">Exit</a>
										</li>
									</ul>
								</div>
							</div>
						</nav>
					</div>
				</div>
			</header>
			<div class="section-divider-a m-hide container">
				<div class="panel panel-default ">
					<div class="panel-heading">Employee query</div>

					<table class="table-hover table" >
						<thead>
							<tr>
								<th>Emp num</th>

								<th >Emp name</th>
								<th>Email</th>
								<th>Tel num</th>
								<th >Date </th>
								<th>Salary</th>
								<th>Job</th>

								<th>Department</th>
								<th align="center">Operation</th>
							</tr>

						</thead>

						<tbody>

							<c:forEach items="${list}" var="emp" >
								<tr>
									<td class="table-bordered">${emp.empId }</td>
									<td class="table-bordered">${emp.empName }</td>
									<td class="table-bordered">${emp.empEmail }</td>
									<td class="table-bordered">${emp.empPhone }</td>

									<td  class="table-bordered">${emp.empHiredate }</td>
									<td class="table-bordered">${emp.empSalary }</td>

									<td class="table-bordered" >${emp.job.jobName }</td>
									<td  class="table-bordered">${emp.dept.deptName }</td>
									<td class="table-bordered">

										<a onclick="updateEmp('${emp.empId}','${adminLevel}')">
											<img src="./img/edit.png"></a>
										&nbsp &nbsp &nbsp
										<a onclick="deleteEmp('${emp.empId}','${adminLevel}')">
											<img src="./img/delete.png"></a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

					<table  class="table table_bordered">
						<thead>
							<tr>
								<td align="center">
									<a onclick="InsertEmp('${adminLevel}')" class="color">Add new employees</a>
								</td>
							</tr>
						</thead>
					</table>

				</div>

			</div>
			<div align="center">
				<ul class="pagination cont">
					<li >
						<a href="#">&laquo;</a>
					</li>
					<li>
						<a href="#">
							1
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li >
						<a href="#">
							2
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a href="#">
							3
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a href="#">
							4
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a href="#">
							5
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li >
						<a href="#">
							6
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a href="#">&raquo;</a>
					</li>
				</ul>
			</div>
		</div>
		<div align="center">
			<a href="DownloadServlet" class="btn btn-default">Export  Excel</a>
		</div>
		<div class="inner-wrap m-hide">
			<div class="inner">
				<div class="full-margin">
					<div class="textbox">
						<div class="textbox-frame">
							<div class="textbox-inner extra-inner-padding">
								<img class="image-center" src="./img/logo.png" alt="Craft beer always on tap" width="180" height="150">
								<h3 class="mtop30">Thanks for our teacher Mr Chen</h3>
								<div class="two-col-text dropcap">
									<p>TeamLeader:Mr Chen</p>
									<p>TeamLeader:Mr Jin</p>
									<p>TeamMate: Mrs  Li</p>
									<p>TeamMate: Mrs  Li</p>
									<p>TeamMate: Mrs  Yu</p>
									<p>TeamMate: Mrs  Shen</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<footer>
		<div class=" m-hide">
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
					<p class="pull-right"><a href="#"><img src="./img/airplane.png"></a></p>
				</div>
			</div>
		</div>
	</footer>

</div>
</div>
<script src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/empManage.js"></script>

</body>
</html>