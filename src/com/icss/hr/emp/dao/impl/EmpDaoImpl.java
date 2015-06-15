package com.icss.hr.emp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.icss.hr.common.ConnFactory;
import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.po.Job;

public class EmpDaoImpl implements EmpDao {
	
	@Override
	public void insert(Emp emp) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call add_emp(?,?,?,?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, emp.getEmpName());
		cstmt.setString(2, emp.getEmpEmail());
		cstmt.setString(3, emp.getEmpPhone());
		cstmt.setDate(4, new java.sql.Date(emp.getEmpHiredate().getTime()));
		cstmt.setInt(5, emp.getJob().getJobId());
		cstmt.setInt(6, emp.getEmpSalary());
		cstmt.setInt(7, emp.getDept().getDeptId());
		cstmt.execute();
		cstmt.close();
		conn.close();
	}
	
	@Override
	public void update(Emp emp) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call update_emp(?,?,?,?,?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		System.out.println(emp.getEmpId()+emp.getEmpName()+emp.getEmpSalary());
		cstmt.setInt(1, emp.getEmpId());
		cstmt.setString(2, emp.getEmpName());
		cstmt.setString(3, emp.getEmpEmail());
		cstmt.setString(4, emp.getEmpPhone());
		cstmt.setDate(5,  new java.sql.Date(emp.getEmpHiredate().getTime()));
		cstmt.setInt(6, emp.getJob().getJobId());
		cstmt.setInt(7, emp.getEmpSalary());
		cstmt.setInt(8, emp.getDept().getDeptId());
		cstmt.execute();
		cstmt.close();
		conn.close();
		
	}

	@Override
	public void delete(int empId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call delete_emp(?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, empId);	
		cstmt.execute();
		cstmt.close();	
		conn.close();
				
	}

	@Override
	public Emp queryById(int empId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from emp where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		
	//	Job job = new Job
	
		Emp emp = null;
		
		if (rs.next()) {
			int job_id = rs.getInt("emp_job_id");
			int dept_id = rs.getInt("emp_dept_id");
			Job job = new JobDaoImpl().queryById(job_id);
			Dept dept = new DeptDaoImpl().queryById(dept_id);
			Date da = new Date(rs.getDate(5).getTime());
			
			emp =new Emp(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3), rs.getString(4), da,job, Integer.parseInt(rs.getString(7)), dept);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return emp;
	}
	

	@Override
	public ArrayList<Emp> query() throws Exception {
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from emp";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Emp emp=null;	     	
	while (rs.next()) {
		int job_id = rs.getInt("emp_job_id");
		int dept_id =rs.getInt("emp_dept_id");
		Job job = new JobDaoImpl().queryById(job_id);
		Dept dept = new DeptDaoImpl().queryById(dept_id);
		System.out.println(dept_id);
		System.out.println(rs.getString(1));
		
		Date da = new Date(rs.getDate(5).getTime());
		
		emp =new Emp(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3), rs.getString(4), da,job, Integer.parseInt(rs.getString(7)), dept);
		list.add(emp);
		}
		
	    rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	
}