package com.springboot.usermanagement.interfaces;

import java.util.List;

import com.springboot.usermanagement.beans.User;
import com.springboot.usermanagement.beans.UserGroup;

/**
 * @author vinaya.m
 *
 */
public interface UserManagementDataSource {
	
	
	/**
	 * @param newUser
	 * @return 
	 */
	public Long insertUser(User newUser);

	/**
	 * @param newGroup
	 */
	public Long insertGroup(UserGroup newGroup);

	
	/**
	 * @param userName
	 * @return
	 */
	public User fetchUser(String userName);

	/**
	 * @param groupName
	 * @return
	 */
	public UserGroup fetchGroup(String groupName);

	/**
	 * @param user
	 */
	public void updateUser(UserGroup userGroup);

	
}