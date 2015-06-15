<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>HRM</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
  <link rel="stylesheet" type="text/css" href="./css/login.css">
  <style>
  
  body{
  background: url("img/bg1.jpg")repeat;
  /*background-color:#0C1C2F;*/
  }
  .radio {
    margin-top: 10px;
  }
  .gradient{
  /*background: url("img/bg.jpg.png")repeat-x;*/
  }
  </style>
  </head>
  
  <body>
<div id="wrapper">
<form name="login-form" class="login-form" action="LoginServlet" method="post">
    <div class="header">
    <h1>HRM</h1>
   <span>HRM Human resources management system.</span>
    </div>
    <div class="content">
  <!--USERNAME--><input  name="adminName" type="username" id="adminName" class="input username" placeholder="Username"  ><!--END USERNAME-->
    <!--PASSWORD--><input name="adminPwd" type="password" id="adminPwd" class="input password" placeholder="Password" ><!--END PASSWORD-->

    </div>
    <div class="footer">
  
       <input name="adminLevel" type="radio" value="1" checked class="radio">Manager
        <br>
         <input type="radio" name="adminLevel" value="2" class="radio">Operator
      
   <input type="submit" name="submit" value="Login" class="button" >
 <!--  <input type="submit" name="submit" value="Register" class="register"> -->
  </div>
</form>
<div class="gradient"></div><!--END GRADIENT-->

<!--DOWNLOAD (DEMO ONLY)--><a href="http://designerfuel.tumblr.com/post/15555140593/login-form-psd-live" class="download">View Resource</a><!--END DOWNLOAD-->
</div>
</body>
</html>