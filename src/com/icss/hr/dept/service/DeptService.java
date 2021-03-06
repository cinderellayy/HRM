package com.icss.hr.dept.service;

import java.util.ArrayList;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.vo.DeptVo;

/**
 * 部门业务对象
 * @author Administrator
 *
 */
public interface DeptService {
	
	void insert(DeptVo vo) throws Exception;
	
	void update(DeptVo vo) throws Exception;
	
	void delete(int deptId) throws Exception;
	
	Dept queryById(int deptId) throws Exception;

	ArrayList<Dept> query() throws Exception;
}