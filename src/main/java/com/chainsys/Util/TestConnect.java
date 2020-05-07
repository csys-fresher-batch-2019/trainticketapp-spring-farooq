package com.chainsys.Util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class TestConnect {
	
	public static Connection getConnection()throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");


		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "farooq", "farooq");
		//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		return connection;
	}
	}
