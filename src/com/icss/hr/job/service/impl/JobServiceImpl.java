package com.icss.hr.job.service.impl;

import java.util.ArrayList;
import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.vo.JobVo;

public class JobServiceImpl implements JobService{
	private JobDaoImpl dao = new JobDaoImpl();
	@Override
	public void delete(int jobId) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(" in JobServiceImpl");
		dao.delete(jobId);
	}

	@Override
	public void insert(JobVo vo) throws Exception {
		Job job = new Job(vo.getJobName(),vo.getJobMinSalary(),vo.getJobMaxSalary());
		dao.insert(job);
		
	}

	@Override
	public ArrayList<Job> query() throws Exception {
		// TODO Auto-generated method stub
		return dao.query();
	}

	@Override
	public Job queryById(int jobId) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryById(jobId);
	}

	@Override
	public void update(JobVo vo) throws Exception {
		// TODO Auto-generated method stub
		Job job = new Job(vo.getJobId(),vo.getJobName(),vo.getJobMinSalary(),vo.getJobMaxSalary());
		dao.update(job);
	}

}
