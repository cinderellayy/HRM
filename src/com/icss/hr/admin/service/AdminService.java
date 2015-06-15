package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.AdminVo;
import com.icss.hr.common.LoginStatus;

public interface AdminService {
	
	LoginStatus login(AdminVo vo) throws Exception;

}
