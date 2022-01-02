package com.cars.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cars.responses.Response;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(Exception.class)
	public String GlobalExceptionMethod(Exception e)
	{
		return e.getMessage();
	}
	
	public ResponseEntity<Response> globalhandler(Exception e, HttpServletRequest req){
		Response r = new Response();
		r.setUri(req.getRequestURI());
		r.setStatusCode(HttpStatus.NOT_FOUND.value());
		r.setStatusName(HttpStatus.NOT_FOUND);
		r.setMessage(e.getMessage());
		return new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
	}
}
