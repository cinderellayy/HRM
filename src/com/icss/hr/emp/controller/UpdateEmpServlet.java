package com.icss.hr.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.impl.EmpServiceImpl;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.impl.JobServiceImpl;

public class UpdateEmpServlet extends HttpServlet {
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();

		//获得表单数据
		//获得表单数据
		       
				String empName = request.getParameter("empName");
				String empEmail = request.getParameter("empEmail");
				String empPhone = request.getParameter("empPhone");
				//System.out.println(request.getParameter("empSalary")+"3333");
				int empSalary = Integer.parseInt(request.getParameter("empSalary"));
				Emp emp = (Emp)request.getSession().getAttribute("emp");
//				System.out.println("------->"+emp.getEmpId());
				try {
					List<Emp> list = new EmpServiceImpl().query();
					request.setAttribute("list", list);
				} catch (Exception e1) {			
					e1.printStackTrace();
				}
					
				Job job = null;
				try {
					ArrayList<Job> list_job = new JobServiceImpl().query();
					request.setAttribute("list_job", list_job);
					//System.out.println(request.getParameter("jobId")+"2222");
					job = new JobDaoImpl().findByName(request.getParameter("jobId"));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				int jobId = job.getJobId();
				
				
				
				 Dept dept = null;
				 try {
					ArrayList<Dept> list_dept = new DeptServiceImpl().query();
					request.setAttribute("list_dept", list_dept);
					dept = new DeptDaoImpl().queryByName(request.getParameter("deptName"));
				    } catch (Exception e1) {
					e1.printStackTrace();
				  }
				int deptId =  dept.getDeptId();
				
				//封装VO对象
				EmpVo vo = new EmpVo(emp.getEmpId(),empName, empEmail, empPhone,new java.sql.Date(new java.util.Date().getTime()),jobId,empSalary, deptId);			
		//调用业务
		EmpServiceImpl service = new EmpServiceImpl();
		
		try {
			service.update(vo);
			//输出提示
			out.println("<script>alert('Update the Emp Successful');location.href='QueryEmpServlet';</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    this.doPost(req, resp);}
}