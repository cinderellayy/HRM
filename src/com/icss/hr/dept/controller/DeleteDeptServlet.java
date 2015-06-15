package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;

public class DeleteDeptServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();

		//获得部门ID
		String deptId = request.getParameter("deptId");
		
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.delete(Integer.parseInt(deptId));
			//输出提示
			out.println("<script>alert('Delete the Dept Successful');location.href='QueryDeptServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}