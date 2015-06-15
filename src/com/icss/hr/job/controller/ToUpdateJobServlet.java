package com.icss.hr.job.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class ToUpdateJobServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

String jobId = request.getParameter("jobId");
HttpSession session = request.getSession();
session.setAttribute("jobId", jobId);

JobServiceImpl service = new JobServiceImpl();

try {
	Job job = service.queryById(Integer.parseInt(jobId));
	
	request.setAttribute("job", job);
	request.getRequestDispatcher("/UpdateJob.jsp").forward(request, response);
}catch (Exception e) {			
	e.printStackTrace();
}

}
}
