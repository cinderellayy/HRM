package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class ToUpdateEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empId = request.getParameter("empId");
		
		EmpServiceImpl service = new EmpServiceImpl();
		JobServiceImpl j_service = new JobServiceImpl();
		DeptServiceImpl d_service = new DeptServiceImpl();
		try {
			Emp emp = service.queryById(Integer.parseInt(empId));
			//request.setAttribute("em", o)
			List<Job> list = j_service.query();
			List<Dept> list_dept = d_service.query();
			request.setAttribute("emp", emp);
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);

			request.setAttribute("list", list);
			request.setAttribute("list_dept", list_dept);
			request.getRequestDispatcher("/UpdateEmp.jsp").forward(request, response);
		}catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}