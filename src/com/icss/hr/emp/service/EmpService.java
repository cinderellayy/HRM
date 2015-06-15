package com.icss.hr.emp.service;

import java.util.ArrayList;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.po.Job;

public interface EmpService {
	
	void insert(EmpVo vo) throws Exception;
	
	void update(EmpVo vo) throws Exception;
	
	void delete(int empId) throws Exception;
	
	Emp queryById(int empId)  throws Exception;
	
	ArrayList<Emp> query() throws Exception;


}