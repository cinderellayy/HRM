
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.css" />
	<meta name="format-detection" content="telephone=no">
	<title>HRM</title>
	<link rel="stylesheet" type="text/css" media="all" href="./css/index.css">

	<style>
	body{
		background:url("./img/bg1.jpg") repeat;

	}

	.carousel-caption{
		background: rgba(90, 169, 720, 0.30);
	}
	.carousel-control {
	background: rgba(90, 169, 720, 0.50);
	}
   .p1{
   	margin-left: 33px;
   	 }
   	.nav-inner{
   		font-family: "微软雅黑";
   	}
  
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
			<div class="">
				<div id="carousel1" class="carousel slide container">
					<div class="carousel-inner">
						<div class="item">
							<img src="./img/carousel1.png" alt="图片一" />
							<div class="carousel-caption">
								<h4>HRM</h4>
								<h4>HRM Human resources management system.</h4>
							</div>
						</div>
						<div class="item  active">
							<img src="./img/carousel5.png" alt="图片二" />
							<div class="carousel-caption">
								<h4>HRM</h4>
								<h4>HRM Human resources management system.</h4>
							</div>
						</div>
						<div class="item">
							<img src="./img/carousel6.png" alt="图片二" />
							<div class="carousel-caption">
								<h4>HRM</h4>
								<h4>HRM Human resources management system.</h4>
							</div>
						</div>
					</div>
					<a href="#carousel1"data-slide="prev"class="left carousel-control">‹</a>
					<a href="#carousel1"data-slide="next"class="right carousel-control">›</a>
				</div>
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
  </body>
</html>
