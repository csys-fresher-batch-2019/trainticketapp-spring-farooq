package com.chainsys.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chainsys.TestConnect;
import com.chainsys.exception.DbException;

public class JdbcUtil {

	public static int executeUpdate(String sql, Object... params) throws DbException {
		int rows = 0;
try(
		Connection con = TestConnect.getConnection();
		PreparedStatement pst1 = con.prepareStatement(sql);){
		int i = 1;
		for (Object param : params) {
			pst1.setObject(i, param);
			i++;
		}
		 rows = pst1.executeUpdate();
		
	}catch(Exception e) {
		throw new DbException("ESTABLISH CONNECTION");
	}
return rows;
	}
	// To call this executeupdate method
	// String sql2 = "insert into
	// user_login(emp_id,passwd,designation)values(?,'pass123',?)";
	// int rows1 = JdbcUtil.executeUpdate(sql2, a.empId , a.designation );


}
