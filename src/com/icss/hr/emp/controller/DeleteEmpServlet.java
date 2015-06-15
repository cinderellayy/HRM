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
		
		//�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		
		//�����
		PrintWriter out = response.getWriter();

		//��ò���ID
		String empId = request.getParameter("empId");
		
		EmpServiceImpl service = new EmpServiceImpl();
		
		try {
			service.delete(Integer.parseInt(empId));
			//�����ʾ
			out.println("<script>alert('Delete the Emp Successful');location.href='QueryEmpServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}