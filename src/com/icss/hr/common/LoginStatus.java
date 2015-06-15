package com.icss.hr.common;

/**
 * 登陆状态
 * 
 * @author Administrator
 * 
 */
public enum LoginStatus {

	NAME_ERROR, // 用户名不存在
	PWD_ERROR, // 密码错误
	LEVEL_ERROR, // 级别错误
	SUCCESS;// 登陆成功

}