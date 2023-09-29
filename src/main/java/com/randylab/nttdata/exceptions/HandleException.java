package com.randylab.nttdata.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {
	
	private static Logger _logger = LoggerFactory.getLogger(HandleException.class);

	@ExceptionHandler(ServiceException.class)
	public final ResponseEntity<?> handleServiceExceptions(ServiceException serviceException) {
		_logger.error("Error Handler ---> ", serviceException.getMessage());
		return new ResponseEntity<>(serviceException.getMessage(), serviceException.getHttpStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleServiceExceptions(Exception exception) {
		_logger.error("Error Not Handler ---> ", exception.getMessage());
		return new ResponseEntity<>("An unexpected error ocurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
