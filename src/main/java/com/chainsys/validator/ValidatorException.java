package com.chainsys.validator;


import org.springframework.stereotype.Component;


public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ValidatorException(String invaliduserId) {
		super(invaliduserId);
	}
	
	

}
