package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;

public class UpdateDeptServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		
		//�����
		PrintWriter out = response.getWriter();

		//��ñ�����
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		//��װVO����
		DeptVo vo = new DeptVo(Integer.parseInt(deptId),deptName,deptLoc);
		
		//����ҵ��
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.update(vo);
			//�����ʾ
			out.println("<script>alert('Update the Dept Successful');location.href='QueryDeptServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}