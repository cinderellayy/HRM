package com.icss.hr.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;
import com.icss.hr.common.LoginStatus;

/**
 * 登陆Servlet
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out =  response.getWriter();
		
		//获得表单数据
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		int adminLevel = Integer.parseInt(request.getParameter("adminLevel"));
		
		//封装VO
		AdminVo vo = new AdminVo(adminName, adminPwd, adminLevel);
		
		//调用Service
		AdminServiceImpl service = new AdminServiceImpl();
		
		try {
			//登陆判断
			LoginStatus loginStatus = service.login(vo);
			
			if (loginStatus == LoginStatus.NAME_ERROR) {
				out.println("<script>alert('Username does not exist');history.back();</script>");
			} else if (loginStatus == LoginStatus.PWD_ERROR) {
				out.println("<script>alert('Error Password ');history.back();</script>");
			} else if (loginStatus == LoginStatus.LEVEL_ERROR) {
				out.println("<script>alert('Error Level');history.back();</script>");
			} else {
				//存储登陆标识
				HttpSession session = request.getSession();
				session.setAttribute("adminName", adminName);
				session.setAttribute("adminLevel", adminLevel);
				out.println("<script>alert('Login Successful');location.href='index.jsp';</script>");
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
	}

}