<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>InsertJob</title>
    <link rel="stylesheet" href="dist/css/bootstrap.css" />
	<link rel="stylesheet" href="dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
		<script type="text/javascript">
			/*验证表单*/
			function checkForm() {				
				var jobName = document.form1.jobName;
				
				if (jobName.value == '' || jobName.value.length>5) {
					alert('Position name cannot be empty and a maximum of 5 characters!');
					jobName.focus();
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

  <div class="panel-heading" align="center">Please enter the job information </div>
<form  class="form-group"name="form1" method="post" action="InsertJobServlet"  onsubmit="return checkForm();">
  <table class="table_border table"  width="75%" align="center">
   
    <tr > 
      <td > 
       Job Name</td>
      <td> 
       
          <input class="form-control" name="jobName" type="text" id="jobName">
       </td>
    </tr>
    <tr > 
      <td> 
       JobMinSalary</td>
      <td> 
        <input  class="form-control" name="jobMinSalary" type="text" id="jobMinSalary"></td>
    </tr>
    <tr> 
      <td> 
      JobMaxSalary</td>
      <td> 
        <input  class="form-control"  name="jobMaxSalary" type="text" id="jobMaxSalary"></td>
    </tr>
    <tr align="center" > 
      <td height="24" colspan="2" > 
       
          <input class="btn" type="submit" name="Submit" value="Submit">&nbsp;
          <input  class="btn" type="button" name="Submit2" value="Reset" onclick="history.back();">
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
			
		</div>
  </body>
</html>
