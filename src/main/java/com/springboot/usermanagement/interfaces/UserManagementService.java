package com.springboot.usermanagement.interfaces;


import org.springframework.stereotype.Component;

import com.springboot.usermanagement.beans.Response;
import com.springboot.usermanagement.beans.User;
import com.springboot.usermanagement.beans.UserGroup;
import com.springboot.usermanagement.exceptions.ResourceNotFoundException;

/**
 * @author vinaya.m
 *
 */
@Component
public interface UserManagementService {
	
	
	/**
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws Exception 
	 */
	public Response createUser(User newUser) throws ResourceNotFoundException, Exception;

	/**
	 * @param newGroup
	 * @return
	 * @throws Exception
	 */
	public Response createGroup(UserGroup newGroup) throws Exception;

	/**
	 * @param userName
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Response getUser(String userName) throws ResourceNotFoundException;

	/**
	 * @param groupName
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Response getGroup(String groupName) throws ResourceNotFoundException;

	/**
	 * @param user
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Response updateUser(UserGroup userGroup) throws ResourceNotFoundException;


}
