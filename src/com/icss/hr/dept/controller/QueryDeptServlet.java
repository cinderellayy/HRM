package com.icss.hr.dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

public class QueryDeptServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		System.out.println("here");
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			ArrayList<Dept> list = service.query();
			//把数据存储到范围中
			request.setAttribute("list", list);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			//转发给JSP视图
			request.getRequestDispatcher("/QueryDept.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}