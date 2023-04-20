package com.map.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(InternalServerError.class)
	  public Object handleException(Exception e) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
		 return "Resource Not Found Please Look Into It !!";
	 }

}
