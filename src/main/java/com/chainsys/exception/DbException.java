package com.chainsys.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class DbException extends Exception {

	@Autowired
	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
super(msg);
	}

	
	
	
}
