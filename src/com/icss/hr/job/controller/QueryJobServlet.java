package com.icss.hr.job.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class QueryJobServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

JobServiceImpl service = new JobServiceImpl();

try {
	ArrayList<Job> list = service.query();
	//�����ݴ洢����Χ��
	request.setAttribute("list", list);
	HttpSession session = request.getSession();
	session.setAttribute("list", list);
	//ת����JSP��ͼ
	request.getRequestDispatcher("/QueryJob.jsp").forward(request, response);
} catch (Exception e) {			
	e.printStackTrace();
}

}
}
	
		
		

	
	
			

