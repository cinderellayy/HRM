package com.icss.hr.emp.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.job.po.Job;

public class DownloadServlet extends HttpServlet {
	private InputStream excelStream;  //���������
    private String excelFileName;

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	/**
	 * Constructor of the object.
	 */
	public DownloadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 try {
	            //��һ��������һ��webbook����Ӧһ��Excel�ļ�
	            HSSFWorkbook wb = new HSSFWorkbook();
	            //�ڶ�������webbook�����һ��sheet����ӦExcel�ļ��е� sheet
	            HSSFSheet sheet = wb.createSheet("��Ϣ��");
	            //����������sheet����ӱ�ͷ��0�У�ע���ϰ汾poi��Excel����������������
	            HSSFRow row = sheet.createRow(0);
	            //���Ĳ���������Ԫ����ʽ������
	            HSSFCellStyle style = wb.createCellStyle();
	            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	            //���岽��������ͷ��Ԫ�񣬲�������ʽ
	            HSSFCell cell;
	            //��ȡlist
	            List<?> list_temp = (List<?>)request.getSession().getAttribute("list");
	           // List<>
	            if(list_temp.get(0).getClass().equals(Dept.class)){
	            	List<Dept> list = (List<Dept>)list_temp;
	            	cell = row.createCell(0);
	            	cell.setCellValue("���ű��");
	            	cell.setCellStyle(style);
	            	
	            	cell = row.createCell(1);
	            	cell.setCellValue("��������");
	            	cell.setCellStyle(style);
	            	
	            	cell = row.createCell(2);
	            	cell.setCellValue("���ŵ�ַ");
	            	cell.setCellStyle(style);
	            	int i = 1;
	            	
	            	//д��ʵ������
	            	for(Dept user: list){
	            		row = sheet.createRow(i);
	            		row.createCell(0).setCellValue(user.getDeptId());
	            		row.createCell(1).setCellValue(user.getDeptName());
	            		row.createCell(2).setCellValue(user.getDeptLoc());
	            		i++;
	            	}
	            	
	            }
	            
          if(list_temp.get(0).getClass().equals(Emp.class)){
            	List<Emp> list = (List<Emp>)list_temp;
	            	
           	cell = row.createCell(0);
            	cell.setCellValue("Ա�����");
           	cell.setCellStyle(style);
	            	
	            	cell = row.createCell(1);
	            	cell.setCellValue("Ա������");
	            	cell.setCellStyle(style);
	            	
            	cell = row.createCell(2);
	            	cell.setCellValue("����");
            	cell.setCellStyle(style);
            	
	            	cell = row.createCell(3);
	            	cell.setCellValue("�绰");
	            	cell.setCellStyle(style);
	            	cell = row.createCell(4);
	            	cell.setCellValue("��ְʱ��");
	            	cell.setCellStyle(style);
	            	cell = row.createCell(5);
	            	cell.setCellValue("����");
	            	cell.setCellStyle(style);
	            	cell = row.createCell(6);
	            	cell.setCellValue("ְ��");
	            	cell.setCellStyle(style);
	            	cell = row.createCell(7);
	            	cell.setCellValue("����");
	            	cell.setCellStyle(style);
	            	
            	//�Ѿ�����һ��
            	   int i = 1;
	            	for(Emp d : list){
            		   row = sheet.createRow(i);
	            		row.createCell(0).setCellValue(d.getEmpId());
	            		row.createCell(1).setCellValue(d.getEmpName());
	            		row.createCell(2).setCellValue(d.getEmpEmail());
	            		row.createCell(3).setCellValue(d.getEmpPhone());
	            		row.createCell(4).setCellValue(d.getEmpHiredate());
            		  
	            		row.createCell(5).setCellValue(d.getEmpSalary());
	            		row.createCell(6).setCellValue(d.getJob().getJobName());
	            		  row.createCell(7).setCellValue(d.getDept().getDeptName());
                		
            	
	            		i++;
	            	}
            }
           
	            if(list_temp.get(0).getClass().equals(Job.class)){
            	List<Job> list = (List<Job>)list_temp;
	            	cell = row.createCell(0);
	            	cell.setCellValue("ְλ���");
            	cell.setCellStyle(style);
	            	
            	cell = row.createCell(1);
	            	cell.setCellValue("ְλ����");
	            	cell.setCellStyle(style);
            	
	            	cell = row.createCell(2);
            	cell.setCellValue("��͹���");
	            	cell.setCellStyle(style);
            	
           	cell = row.createCell(3);
            	cell.setCellValue("��߹���");
	            	cell.setCellStyle(style);
	            	
	            	
	            	
            	int i = 1;
            	for(Job p : list){
            		row = sheet.createRow(i);
            		row.createCell(0).setCellValue(p.getJobId());
            		row.createCell(1).setCellValue(p.getJobName());
	            	row.createCell(2).setCellValue(p.getJobMinSalary());
            		row.createCell(3).setCellValue(p.getJobMinSalary());
       
            		i++;
	            	}
           }
//	            if(list_temp.get(0).getClass().equals(Staff.class)){
//	            	List<Staff> list = (List<Staff>)list_temp;
//	            	cell = row.createCell(0);
//	            	cell.setCellValue("Ա�����");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(1);
//	            	cell.setCellValue("Ա������");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(2);
//	            	cell.setCellValue("Ա������");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(3);
//	            	cell.setCellValue("Ա���绰");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(4);
//	            	cell.setCellValue("��ְʱ��");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(5);
//	            	cell.setCellValue("Ա������");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(6);
//	            	cell.setCellValue("���貿��");
//	            	cell.setCellStyle(style);
//	            	
//	            	cell = row.createCell(7);
//	            	cell.setCellValue("ְλ");
//	            	cell.setCellStyle(style);
//	            	
//	            	int i = 0;
//	            	for(Staff s : list){
//	            		row = sheet.createRow(i);
//	            		row.createCell(0).setCellValue(s.getStaff_account());
//	            		row.createCell(1).setCellValue(s.getStaff_name());
//	            		row.createCell(2).setCellValue(s.getStaff_mail());
//	            		row.createCell(3).setCellValue(s.getStaff_tel());
//	            		row.createCell(4).setCellValue(s.getStaff_beginTime());
//	            		row.createCell(5).setCellValue(s.getStaff_pay());
//	            		row.createCell(6).setCellValue(s.getD_name());
//	            		row.createCell(7).setCellValue(s.getP_name());
//	            		i++;
//	            	}
//	            }
//
//	           
//
//	            //��������д��ʵ�����ݣ�ʵ��Ӧ������Щ���ݴ����ݿ�õ�
//	       /*     Date today = new Date();
//	            long aDay = 1000L*60*60*24;
//	            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//	            for (int i = 1; i <= 10; i++) {
//	                row = sheet.createRow(i);
//	                row.createCell(0).setCellValue(i);
//	                row.createCell(1).setCellValue("Ա��" + i);
//	                row.createCell(2).setCellValue("�ܹ�˾");
//	                row.createCell(3).setCellValue("��ͨԱ��");
//	                row.createCell(4).setCellValue(fmt.format(new Date(today.getTime() + i * aDay)));
//	                row.createCell(5).setCellValue("Ա����ע");
//	            }
	
	            //���߲������ļ��浽����
	            response.setContentType("application/vnd.ms-excel");        //�ĳ����excel�ļ�
	            response.setHeader("Content-disposition","attachment; filename=file.xls" );
	            OutputStream os =response.getOutputStream();
	            wb.write(os);
	            os.flush();
	            wb.close();

	          
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
