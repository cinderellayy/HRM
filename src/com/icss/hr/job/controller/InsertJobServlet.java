package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.JobVo;

public class  InsertJobServlet extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

//设置请求编码
request.setCharacterEncoding("utf-8");
//设置响应编码
response.setContentType("text/html;charset=utf-8");

//输出流
PrintWriter out = response.getWriter();

//获得表单数据
String jobName = request.getParameter("jobName");
int jobMinSalary=Integer.parseInt(request.getParameter("jobMinSalary"));//String类型转化为Int类型
int jobMaxSalary=Integer.parseInt(request.getParameter("jobMaxSalary"));
//String jobMinSalary=request.getParameter("jobMinSalary");
//String jobMaxSalary=request.getParameter("jobMaxSalary");
//int jobMinSalary=Integer.parseInt("jobMinSalary");
//int jobMaxSalary=Integer.parseInt("jobMaxSalary");//String类型转化为Int类型
//String  jobMaxSalary= request.getParameter("jobMaxSalary");

//封装VO对象

JobVo vo = new JobVo(jobName,jobMinSalary,jobMaxSalary);

//调用业务
JobServiceImpl service = new JobServiceImpl();

try {
	service.insert(vo);
	//输出提示
	out.println("<script>alert('Insert Position Successful');location.href='QueryJobServlet';</script>");
} catch (Exception e) {			
	e.printStackTrace();
}
}

}
