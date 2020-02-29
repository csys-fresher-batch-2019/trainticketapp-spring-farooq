package com.chainsys.Util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;


public class TestConnect {
	
	public static Connection getConnection()throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");


		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "farooq", "farooq");
		return connection;
	}
	public static Jdbi getJdbi() {
		Connection connection = null;
		try {
			connection = TestConnect.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Jdbi jdbi = Jdbi.create(connection);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}
}
