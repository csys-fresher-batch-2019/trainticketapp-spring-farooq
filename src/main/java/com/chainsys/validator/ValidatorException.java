package com.chainsys.validator;

import org.springframework.stereotype.Component;

@Component
public class ValidatorException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public ValidatorException(int invalidUserId) {

	}

	public ValidatorException(String invaliduserId) {
		super(invaliduserId);
	}
	
	

}
