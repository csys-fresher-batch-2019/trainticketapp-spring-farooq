package com.chainsys.validator;

public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValidatorException(String invaliduserId) {
		super(invaliduserId);
	}
	
	

}
