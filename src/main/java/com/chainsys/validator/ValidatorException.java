package com.chainsys.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ValidatorException extends Exception {

	
	private static final long serialVersionUID = 1L;
@Autowired
	public ValidatorException(String invaliduserId) {
		super(invaliduserId);
	}
	
	

}
