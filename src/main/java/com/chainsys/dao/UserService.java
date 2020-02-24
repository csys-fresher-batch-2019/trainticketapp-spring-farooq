package com.chainsys.dao;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.TestConnect;
import com.chainsys.exception.DbException;

public class UserService {

	public void blockUser(int userid, int status) throws DbException {

		Jdbi jdbi = TestConnect.getJdbi();
		RegistrationDAO obj=jdbi.onDemand(RegistrationDAO.class);
		obj.blockUser( userid, status);

	}

}
