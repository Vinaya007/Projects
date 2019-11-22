package com.springboot.usermanagement.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
	
	private long timestamp;
	private int responseCode;
	private String responseMessage=null;
	private String flag=null;
	private User user=null;
	private UserGroup group=null;	

	public Response() {}
	
	
	public Response(long timestamp, int responseCode, String responseMessage,User user) {
		super();
		this.timestamp = timestamp;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.user=user;
	}
	
	public Response(long timestamp, int responseCode, String responseMessage,UserGroup userGroup) {
		super();
		this.timestamp = timestamp;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.group=userGroup;
	}
	
	public Response(long timestamp, int responseCode, String responseMessage) {
		super();
		this.timestamp = timestamp;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserGroup getGroup() {
		return group;
	}


	public void setGroup(UserGroup group) {
		this.group = group;
	}


	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	
	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}

}
