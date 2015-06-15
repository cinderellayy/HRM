package com.icss.hr.job.dao;
import java.util.ArrayList;
import com.icss.hr.job.po.Job;
public interface JobDao {

	void insert(Job job) throws Exception; 
	
	void update(Job job) throws Exception; 
	
	void delete(int JobId) throws Exception;
	
    Job queryById(int jobId) throws Exception;

	ArrayList<Job> query() throws Exception;

	Job findByName(String name) throws Exception;

}

