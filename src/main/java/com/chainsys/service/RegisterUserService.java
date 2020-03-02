package com.chainsys.service;

import java.time.LocalDate;

import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import com.chainsys.Util.TestConnect;
import com.chainsys.dao.RegistrationDAO;
import com.chainsys.exception.DbException;
@Service
public class RegisterUserService {
	private Jdbi jdbi = TestConnect.getJdbi();
	RegistrationDAO obj=jdbi.onDemand(RegistrationDAO.class);


	public int blockUser(int userid, int status) throws DbException {

		return obj.blockUser( userid, status);

	}
	public int registrationInsert(String username, String password, String emailid, long phonenumber, String gender,
			LocalDate dob, String cityname) throws DbException {
		
		return obj.registrationInsert(username, password, emailid, phonenumber, gender, dob, cityname);
		
	}

}
