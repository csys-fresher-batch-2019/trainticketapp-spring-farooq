package com.chainsys.validator;

public class ValidatorException extends Exception {

	public ValidatorException(int invalidUserId) {

	}

	public ValidatorException(String invaliduserId) {
		super(invaliduserId);
	}
	
	

}
