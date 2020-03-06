package com.chainsys.validator;

import org.springframework.stereotype.Component;

@Component
public class UserValidator {
	
	public static void validateUserIdAndTrainNumber(int userId, String trainNumber) throws ValidatorException {
		if (userId == 0) {
			throw new ValidatorException(ErrorConstants.INVALID_USER_ID);
		}	
		
	}
	public static void validateregistration(String emailId,String username,String pass,String pass1,long phonenumber,String city) {
		if(emailId==null) {
throw new ValidatorException(ErrorConstants.INVALID_EMAIL_ID);
}else if(emailId=="") {
	throw new ValidatorException(ErrorConstants.NULL_VALUES);
}else if(username==null) {
	throw new ValidatorException(ErrorConstants.INVALID_USERNAME);
}else if(username=="") {
	throw new ValidatorException(ErrorConstants.NULL_VALUES);
}
	}

private class ErrorConstants {
	
	public static final String INVALID_USER_ID= "Invalid UserId";
	public static final String NULL_VALUES= "Cannot Insert Null Values";
	public static final String INVALID_EMAIL_ID= "Invalid EmailId";
	public static final String INVALID_PASSWORD= "Invalid Password";
	public static final String INVALID_PHONENUMBER= "Invalid Phonenumber";
	public static final String INVALID_USERNAME= "Invalid Username";

}

}
