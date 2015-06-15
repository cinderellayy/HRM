package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * 工厂方法
 * @author Administrator
 *
 */
public class ConnFactory {

	public static Connection getConnection() throws SQLException {
		
		DriverManager.registerDriver(new OracleDriver());
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "myhr";
		String password = "myhr";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
}
