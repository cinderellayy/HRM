package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.emp.service.impl.EmpServiceImpl;

public class DeleteEmpServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();

		//获得部门ID
		String empId = request.getParameter("empId");
		
		EmpServiceImpl service = new EmpServiceImpl();
		
		try {
			service.delete(Integer.parseInt(empId));
			//输出提示
			out.println("<script>alert('Delete the Emp Successful');location.href='QueryEmpServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}