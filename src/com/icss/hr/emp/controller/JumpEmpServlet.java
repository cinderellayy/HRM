package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

/**
 * Servlet implementation class JumpEmpServlet
 */
public class JumpEmpServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JobServiceImpl Jservice = new JobServiceImpl();
		DeptServiceImpl Dservice= new DeptServiceImpl();
		EmpServiceImpl service = new EmpServiceImpl();
		try {
			ArrayList<Job> list_job = Jservice.query();
			ArrayList<Dept> list_dept = Dservice.query();
			ArrayList<Emp> list = service.query();
			//把数据存储到范围中
			request.setAttribute("list", list);
			request.setAttribute("list_dept", list_dept);
			request.setAttribute("list_job", list_job);
			//转发给JSP视图
			request.getRequestDispatcher("/QueryEmp.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}