package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;

public class InsertDeptServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		
		//�����
		PrintWriter out = response.getWriter();

		//��ñ�����
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		//��װVO����
		DeptVo vo = new DeptVo(deptName,deptLoc);
		
		//����ҵ��
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.insert(vo);
			//�����ʾ
			out.println("<script>alert('Insert the Dept Successful');location.href='QueryDeptServlet';</script>");
			System.out.println("hereddddddddd");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}