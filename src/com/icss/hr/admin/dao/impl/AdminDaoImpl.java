package com.icss.hr.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.po.Admin;
import com.icss.hr.common.ConnFactory;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin queryByName(String adminName) throws Exception {
		
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM admin WHERE admin_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, adminName);
		ResultSet rs = pstmt.executeQuery();
		
		Admin admin = null;
		
		if (rs.next()) {
			admin = new Admin(rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return admin;
	}

}
