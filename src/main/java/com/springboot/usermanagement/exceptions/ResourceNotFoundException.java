package com.springboot.usermanagement.exceptions;

public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private String message;
	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Default Constructor
	 */	
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parameterized constructor which takes exception message
	 *  and cascade it to the Exception class.
	 *  
	 * @param message Indicates the reason for Exception 
	 */
	public ResourceNotFoundException(int status,String message) {
		// TODO Auto-generated constructor stub
		super(message);		
		this.status=status;
		this.message=message;
	}
}
