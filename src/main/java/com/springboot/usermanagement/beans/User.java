package com.springboot.usermanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;	
	@Column(name="user_name")
	private String userName;	
	@Column(name="mobile_number")
	private String mobileNumber;
	@Column(name="email_id")
	private String emailId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
	private UserGroup group;	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*public long getUserId() {
		return userId;
	}*/
	/*public void setUserId(long userId) {
		this.userId = userId;
	}*/
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/*public UserGroup getGroup() {
		return group;
	}*/
	public void setGroup(UserGroup group) {
		this.group = group;
	}
	
	

}
