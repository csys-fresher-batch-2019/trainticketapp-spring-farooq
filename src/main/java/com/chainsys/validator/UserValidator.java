package com.chainsys.validator;

public class UserValidator {
	
	public static void validateUserIdAndTrainNumber(int userId, String trainNumber) throws ValidatorException {
		if (userId == 0) {
			throw new ValidatorException(ErrorConstants.INVALID_USER_ID);
		}		
	}

private class ErrorConstants {
	public static final String INVALID_USER_ID
	= "Invalid UserId";
}

}
