package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.po.Job;

public class InsertEmpServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();

		//获得表单数据
		String empName = request.getParameter("empName");
		String empEmail = request.getParameter("empEmail");
		String empPhone = request.getParameter("empPhone");
		
		try {
			List<Emp> list = new EmpServiceImpl().query();
			request.setAttribute("list", list);
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
			
		Job job = null;
		try {
			job = new JobDaoImpl().findByName(request.getParameter("jobId"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 int jobId =  job.getJobId();		
		 int empSalary = Integer.parseInt(request.getParameter("empSalary"));
		 Dept dept = null;
		 try {
			dept = new DeptDaoImpl().queryByName(request.getParameter("deptName"));
		    } catch (Exception e1) {
			e1.printStackTrace();
		  }
		int deptId =  dept.getDeptId();
		
		//封装VO对象
		EmpVo vo = new EmpVo(empName, empEmail, empPhone,new java.sql.Date(new java.util.Date().getTime()),jobId,empSalary, deptId);		
		//调用业务
		EmpServiceImpl service = new EmpServiceImpl();		
		try {
			service.insert(vo);
			//输出提示
			out.println("<script>alert('Insert the Emp successful');location.href='QueryEmpServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
    this.doPost(req, resp);
}


}