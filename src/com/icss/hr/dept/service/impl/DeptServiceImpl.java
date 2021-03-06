package com.icss.hr.dept.service.impl;

import java.util.ArrayList;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.vo.DeptVo;

public class DeptServiceImpl implements DeptService {
	
	private DeptDaoImpl dao = new DeptDaoImpl();

	@Override
	public void insert(DeptVo vo) throws Exception {
		//voתpo
		Dept dept = new Dept(vo.getDeptName(),vo.getDeptLoc());
		dao.insert(dept);
	}

	@Override
	public void delete(int deptId) throws Exception {
		dao.delete(deptId);
	}

	@Override
	public void update(DeptVo vo) throws Exception {
		//voתpo
		Dept dept = new Dept(vo.getDeptId(),vo.getDeptName(),vo.getDeptLoc());
		dao.update(dept);
	}

	@Override
	public Dept queryById(int deptId) throws Exception {

		return dao.queryById(deptId);
	}

	@Override
	public ArrayList<Dept> query() throws Exception {

		return dao.query();
	}

}