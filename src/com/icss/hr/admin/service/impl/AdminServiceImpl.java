package com.icss.hr.admin.service.impl;

import com.icss.hr.admin.dao.impl.AdminDaoImpl;
import com.icss.hr.admin.po.Admin;
import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.AdminVo;
import com.icss.hr.common.LoginStatus;

public class AdminServiceImpl implements AdminService {
	
	private AdminDaoImpl dao = new AdminDaoImpl();

	@Override
	public LoginStatus login(AdminVo vo) throws Exception {
		
		Admin admin = dao.queryByName(vo.getAdminName());
		
		if (admin == null)
			return LoginStatus.NAME_ERROR;
		else if (!vo.getAdminPwd().equals(admin.getAdminPwd()))
			return LoginStatus.PWD_ERROR;
		else if (vo.getAdminLevel() != admin.getAdminLevel())
			return LoginStatus.LEVEL_ERROR;
		else
			return LoginStatus.SUCCESS;
		
	}

}
