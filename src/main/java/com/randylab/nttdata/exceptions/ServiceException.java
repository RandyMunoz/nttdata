package com.randylab.nttdata.exceptions;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

	private final String errorCode;
	private final String message;
	private final HttpStatus httpStatus;

	public ServiceException(String errorCode, String message, HttpStatus httpStatus) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
