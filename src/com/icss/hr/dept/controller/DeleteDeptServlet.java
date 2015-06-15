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
		
		//�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		
		//�����
		PrintWriter out = response.getWriter();

		//��ò���ID
		String deptId = request.getParameter("deptId");
		
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.delete(Integer.parseInt(deptId));
			//�����ʾ
			out.println("<script>alert('Delete the Dept Successful');location.href='QueryDeptServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}