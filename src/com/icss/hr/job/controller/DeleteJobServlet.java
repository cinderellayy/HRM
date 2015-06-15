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

//�����������
request.setCharacterEncoding("utf-8");
//������Ӧ����
response.setContentType("text/html;charset=utf-8");

//�����
PrintWriter out = response.getWriter();

//��ò���ID
String jobId = request.getParameter("jobId");

JobServiceImpl service = new JobServiceImpl();

try {
//	System.out.println("here1");
	service.delete(Integer.parseInt(jobId));
//	System.out.println("here2");
	//�����ʾ
	out.println("<script>alert('Delete the position successful ');location.href='QueryJobServlet';</script>");
//	System.out.println("here3");
} catch (Exception e) {			
	e.printStackTrace();
}

}


}
