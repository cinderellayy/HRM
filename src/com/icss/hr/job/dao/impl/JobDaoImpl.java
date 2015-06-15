package com.icss.hr.job.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.ConnFactory;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.po.Job;


public class JobDaoImpl implements JobDao {
	@Override
	public void insert(Job job) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call add_job(?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, job.getJobName());
		cstmt.setInt(2, job.getJobMinSalary());
		cstmt.setInt(3, job.getJobMaxSalary());
		
		cstmt.execute();
		
		cstmt.close();	
		conn.close();
		
	}

	@Override
	public void delete(int jobId) throws Exception {
		Connection conn = ConnFactory.getConnection();
//	   System.out.print("qqqqq");
		String sql = "{call delete_job(?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1,jobId);	
		cstmt.execute();
		cstmt.close();	
		conn.close();
//		 System.out.print("qqqqq1");
		
	}
	@Override
	public void update(Job job) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call update_job(?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, job.getJobId());
		cstmt.setString(2, job.getJobName());
		cstmt.setInt(3, job.getJobMinSalary());
		cstmt.setInt(4, job.getJobMaxSalary());
		
		cstmt.execute();
		cstmt.close();	
		conn.close();
		
	}

	
	@Override
	public ArrayList<Job> query() throws Exception {
    ArrayList<Job> list = new ArrayList<Job>();
		
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from job";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			//System.out.println(rs.getInt("j"));
			Job job = new Job(Integer.parseInt(rs.getString("job_id")),rs.getString("job_name"),Integer.parseInt(rs.getString("Job_Min_Salary")),Integer.parseInt(rs.getString("Job_Max_Salary")));
			list.add(job);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

	@Override
	public Job queryById(int jobId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from job where job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		ResultSet rs = pstmt.executeQuery();
		
		Job job = null;
		
		if (rs.next()) {
		 job = new Job(Integer.parseInt(rs.getString("job_id")),rs.getString("job_name"),Integer.parseInt(rs.getString("Job_Min_Salary")),Integer.parseInt(rs.getString("Job_Max_Salary")));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return job;
	}



	@Override
	public Job findByName(String name) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from job where job_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		
		Job job = null;
		
		if (rs.next()) {
		 job = new Job(Integer.parseInt(rs.getString("job_id")),rs.getString("job_name"),Integer.parseInt(rs.getString("Job_Min_Salary")),Integer.parseInt(rs.getString("Job_Max_Salary")));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return job;
	}


	

}
