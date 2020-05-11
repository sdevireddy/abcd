package com.royalehotel.exceptions;

import java.lang.RuntimeException;
import java.util.List;

public class ValidationException extends RuntimeException {
	private List<String> args;
	
	public ValidationException(String message) {
		super(message);
	}
	
	public ValidationException(String message, List<String> args) {
		super(message);
		this.args=args;
	}

}
