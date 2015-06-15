package com.icss.hr.emp.controller;

import java.io.IOException;
import java.util.ArrayList;
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

public class QueryEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		EmpServiceImpl service = new EmpServiceImpl();
		JobServiceImpl j_service = new JobServiceImpl();
		DeptServiceImpl d_service = new DeptServiceImpl();
		try {
			ArrayList<Emp> list = service.query();
						
			//�����ݴ洢����Χ��
			request.setAttribute("list", list);
			//Ҫ���ɶ��������ʾ�����ǲ���֮����ת����ʾ
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			
			//ת����JSP��ͼ
			request.getRequestDispatcher("/QueryEmp.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}