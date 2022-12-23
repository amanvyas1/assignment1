package com.aman.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(EntryException.class)
	public ResponseEntity<ErrorBean> entryExceptionHandler(EntryException ee, WebRequest wr) {
		ErrorBean error = new ErrorBean();
		error.setDetails(wr.getDescription(false));
		error.setTimestamp(LocalDateTime.now());	
		error.setMessage(ee.getMessage());
		return new ResponseEntity<ErrorBean>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorBean> globalExceptionHandler(Exception ie, WebRequest wr) {
		ErrorBean error = new ErrorBean();
		error.setMessage(ie.getMessage());
		error.setDetails(wr.getDescription(false));
		error.setTimestamp(LocalDateTime.now());	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorBean> noHandlerFoundHandler(NoHandlerFoundException nhfe, WebRequest wr) {
		ErrorBean error = new ErrorBean();
		error.setMessage(nhfe.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setDetails(wr.getDescription(false));	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	


}
