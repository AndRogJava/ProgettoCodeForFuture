package com.ats.exception;

public class DaoException extends Exception {
public DaoException() {
		
	}
	public DaoException(String arg0) {
		super(arg0);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}
}