package com.chainsys.service;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.Util.TestConnect;
import com.chainsys.dao.RegistrationDAO;
import com.chainsys.exception.DbException;

public class UserService {

	public void blockUser(int userid, int status) throws DbException {

		Jdbi jdbi = TestConnect.getJdbi();
		RegistrationDAO obj=jdbi.onDemand(RegistrationDAO.class);
		obj.blockUser( userid, status);

	}
	

}
