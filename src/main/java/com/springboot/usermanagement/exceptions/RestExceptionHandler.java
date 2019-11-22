package com.springboot.usermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.usermanagement.beans.Response;
import com.springboot.usermanagement.utility.CommonConstants;
/**
 * @author vinaya.m
 *
 */
@ControllerAdvice
public class RestExceptionHandler {
	
	/**
	 * Handles ResourceNotFoundException thrown by the Application.
	 * @param e The ResourceNotFoundException thrown from the Application
	 * @return ResponseEntity Of type Response.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response> handleResourceNotFound(ResourceNotFoundException e){		
		return new ResponseEntity<Response>(new Response(System.currentTimeMillis(), e.getStatus(), e.getMessage()), HttpStatus.NOT_FOUND); 
		}
	
	/**Handles generic exceptions that are not handled by the above handlers.
	 * @param e The Exception thrown from the Application
	 * @return ResponseEntity Of type Response.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> generalExceptionHandler(Exception e){		
		e.printStackTrace();		
		return new ResponseEntity<Response>(new Response(System.currentTimeMillis(),CommonConstants.TECHNICAL_ERROR_CODE, CommonConstants.TECHNICAL_ERROR), HttpStatus.BAD_REQUEST);
	}
	
	

}
