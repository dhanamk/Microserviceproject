package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//status code not matched so we need to write


@RestControllerAdvice
public class StockPriceExceptionHandler {
	//we need to dipsplay message so return type is String
	@ExceptionHandler(CompanyNotAvailableException.class)
	public ResponseEntity<String> handleCompanyNotAvailableException(Exception e)
	{
		String msg=e.getMessage();
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
}
