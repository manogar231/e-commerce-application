package com.map.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(Exception.class)
	  public Object handleException(Exception e) {
		 return "Resource Not Found Please Look Into It !!";
	 }

}
