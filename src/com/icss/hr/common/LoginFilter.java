package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		System.out.println("请求地址：" + request.getRequestURI());

		String uri = request.getRequestURI();// 获得请求URI地址
		String root = request.getContextPath();// 获得web应用根目录

		// 如果不是以下url，必须是登陆状态
		if (!uri.equals(root + "/") 
				&& !uri.equals(root + "/login.jsp")
				&& !uri.equals(root + "/LoginServlet")
				&& !uri.startsWith(root + "/css")
				&& !uri.startsWith(root + "/js")
				&& !uri.startsWith(root + "/img")) {

			//判断是否登陆
			HttpSession session = request.getSession();
			String adminName = (String) session.getAttribute("adminName");
			Integer adminLevel = (Integer) session.getAttribute("adminLevel");
				
			if (adminName == null) {
				response.sendRedirect(root + "/login.jsp");
				return;
			}
			
		}

		// 继续向下执行，否则默认是拦截！！请求会终止
		arg2.doFilter(arg0, arg1);
	}

}