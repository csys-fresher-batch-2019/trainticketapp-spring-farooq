package com.chainsys.validator;

import org.springframework.stereotype.Component;

@Component
public class ValidatorException extends Exception {

	public ValidatorException(int invalidUserId) {

	}

	public ValidatorException(String invaliduserId) {
		super(invaliduserId);
	}
	
	

}
