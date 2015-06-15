
package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.JobVo;

public class UpdateJobServlet  extends HttpServlet  {
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
HttpSession sessin = request.getSession();
String j = (String)sessin.getAttribute("jobId");
int jobId = Integer.parseInt(j);
//int jobMinSalary=Integer.parseInt("jobMinSalary");
//int jobMaxSalary=Integer.parseInt("jobMaxSalary");//String����ת��ΪInt����

//��װVO����
JobVo vo = new JobVo(jobId,jobName,jobMinSalary,jobMaxSalary);


//����ҵ��
JobServiceImpl service = new JobServiceImpl();

try {
	service.update(vo);
	//�����ʾ
	out.println("<script>alert('Update the Position Successful');location.href='QueryJobServlet';</script>");
} catch (Exception e) {			
	e.printStackTrace();
}

}

}
