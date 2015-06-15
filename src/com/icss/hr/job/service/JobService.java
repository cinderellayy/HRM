package com.icss.hr.job.service;
import java.util.ArrayList;

import com.icss.hr.job.po.Job;
import com.icss.hr.job.vo.JobVo;

public interface JobService {

	void insert(JobVo vo) throws Exception;
	
	void update(JobVo vo) throws Exception;
	
	void delete(int jobId) throws Exception;
	
    Job queryById(int jobId) throws Exception;

	ArrayList<Job> query() throws Exception;
	

}
