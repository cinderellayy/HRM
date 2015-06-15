package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;
import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.JobVo;

public class  InsertJobServlet extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

//�����������
request.setCharacterEncoding("utf-8");
//������Ӧ����
response.setContentType("text/html;charset=utf-8");

//�����
PrintWriter out = response.getWriter();

//��ñ�����
String jobName = request.getParameter("jobName");
int jobMinSalary=Integer.parseInt(request.getParameter("jobMinSalary"));//String����ת��ΪInt����
int jobMaxSalary=Integer.parseInt(request.getParameter("jobMaxSalary"));
//String jobMinSalary=request.getParameter("jobMinSalary");
//String jobMaxSalary=request.getParameter("jobMaxSalary");
//int jobMinSalary=Integer.parseInt("jobMinSalary");
//int jobMaxSalary=Integer.parseInt("jobMaxSalary");//String����ת��ΪInt����
//String  jobMaxSalary= request.getParameter("jobMaxSalary");

//��װVO����

JobVo vo = new JobVo(jobName,jobMinSalary,jobMaxSalary);

//����ҵ��
JobServiceImpl service = new JobServiceImpl();

try {
	service.insert(vo);
	//�����ʾ
	out.println("<script>alert('Insert Position Successful');location.href='QueryJobServlet';</script>");
} catch (Exception e) {			
	e.printStackTrace();
}
}

}
