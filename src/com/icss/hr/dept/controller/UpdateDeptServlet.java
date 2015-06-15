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

		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();

		//获得表单数据
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		//封装VO对象
		DeptVo vo = new DeptVo(Integer.parseInt(deptId),deptName,deptLoc);
		
		//调用业务
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			service.update(vo);
			//输出提示
			out.println("<script>alert('Update the Dept Successful');location.href='QueryDeptServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}