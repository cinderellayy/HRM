package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.impl.JobServiceImpl;

public class DeleteJobServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

//设置请求编码
request.setCharacterEncoding("utf-8");
//设置响应编码
response.setContentType("text/html;charset=utf-8");

//输出流
PrintWriter out = response.getWriter();

//获得部门ID
String jobId = request.getParameter("jobId");

JobServiceImpl service = new JobServiceImpl();

try {
//	System.out.println("here1");
	service.delete(Integer.parseInt(jobId));
//	System.out.println("here2");
	//输出提示
	out.println("<script>alert('Delete the position successful ');location.href='QueryJobServlet';</script>");
//	System.out.println("here3");
} catch (Exception e) {			
	e.printStackTrace();
}

}


}
