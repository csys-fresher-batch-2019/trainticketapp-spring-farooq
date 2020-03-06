package com.chainsys.service;

import java.time.LocalDate;

import org.jdbi.v3.core.Jdbi;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Service;
import com.chainsys.Util.TestConnect;
import com.chainsys.dao.RegistrationDAO;
import com.chainsys.dao.impl.RegistrationImplementation;
import com.chainsys.exception.DbException;
import com.chainsys.exception.ErrorMessages;
import com.chainsys.exception.ServiceException;
import com.chainsys.validator.UserValidator;
@Service

public class RegisterService {
	
	

	RegistrationDAO obj = new RegistrationImplementation();
	public int blockUser(int userid, int status) throws DbException {

		return obj.blockUser( userid, status);

	}
	public int registrationInsert(String username, String password, String emailid, long phonenumber, String gender,
			LocalDate dob, String cityname) throws ServiceException, DbException {
		try {
UserValidator.validateregistration(emailid, username, password, password, phonenumber, cityname);
}
		catch(Exception e) {
			throw new ServiceException("invalid data");
		}
		return obj.registrationInsert(username, password, emailid, phonenumber, gender, dob, cityname);
		
	}

}
