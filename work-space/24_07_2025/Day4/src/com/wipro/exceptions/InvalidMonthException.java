package com.wipro.exceptions;

public class InvalidMonthException extends Exception {
	static String input;
	public InvalidMonthException(String messeage) {
		super(input);
	}

}
