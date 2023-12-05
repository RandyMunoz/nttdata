package com.randylab.nttdata.exceptions;

public class ExceptionResponse {

	private final String errorCode;
	private final String message;

	public ExceptionResponse(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

}
