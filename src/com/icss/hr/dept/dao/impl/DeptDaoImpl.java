package com.icss.hr.dept.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.ConnFactory;
import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.po.Dept;

/**
 * 部门DAO具体实现类
 */
public class DeptDaoImpl implements DeptDao {
	
	@Override
	public void insert(Dept dept) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call add_dept(?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, dept.getDeptName());
		cstmt.setString(2, dept.getDeptLoc());
//		System.out.println("------>");
		cstmt.execute();
		cstmt.close();	
		conn.close();
	}
		
	@Override
	public void delete(int deptId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call delete_dept(?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, deptId);	
		cstmt.execute();
		cstmt.close();	
		conn.close();
	}

	@Override
	public void update(Dept dept) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "{call update_dept(?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, dept.getDeptId());
		cstmt.setString(2, dept.getDeptName());
		cstmt.setString(3, dept.getDeptLoc());
		cstmt.execute();
		cstmt.close();	
		conn.close();
	}
	
	@Override
	public Dept queryById(int deptId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		Dept dept = null;
		
		if (rs.next()) {
			dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return dept;
	}

	@Override
	public ArrayList<Dept> query() throws Exception {
		
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from dept";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
			list.add(dept);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	@Override
	public Dept queryByName(String name) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from dept where dept_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		
		Dept dept = null;
		
		if (rs.next()) {
			dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return dept;
	}

}