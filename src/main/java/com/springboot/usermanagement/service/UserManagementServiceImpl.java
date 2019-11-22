
package com.springboot.usermanagement.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springboot.usermanagement.beans.Response;
import com.springboot.usermanagement.beans.User;
import com.springboot.usermanagement.beans.UserGroup;
import com.springboot.usermanagement.controller.UserManagementController;
import com.springboot.usermanagement.exceptions.ResourceNotFoundException;
import com.springboot.usermanagement.interfaces.UserManagementDataSource;
import com.springboot.usermanagement.interfaces.UserManagementService;
import com.springboot.usermanagement.utility.CommonConstants;

/**
 * 
 * @author vinaya.m
 * @version 1.0
 * 
 *
 */
@Component
public class UserManagementServiceImpl implements UserManagementService {
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	@Autowired
	@Qualifier(value="userManagementDao")
	private UserManagementDataSource dataSource=null;   	
	public Response response=null;
	

	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementService#createUser(com.springboot.usermanagement.beans.User)
	 */
	@Override
	public Response createUser(User newUser) throws Exception {
		// TODO Auto-generated method stub
		Long transId=null;		
		transId=dataSource.insertUser(newUser);
		if(transId==null){
			throw new Exception();
		}else{
			response=new Response(System.currentTimeMillis(),
					CommonConstants.SUCCESS_CODE,
					CommonConstants.SUCCESS
					);
			return response;
		}
	}

	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementService#createGroup(com.springboot.usermanagement.beans.UserGroup)
	 */
	@Override
	public Response createGroup(UserGroup newGroup) throws Exception {
		// TODO Auto-generated method stub
		Long transId=null;	
		transId=dataSource.insertGroup(newGroup);		
		if(transId==null){
			throw new Exception();
		}else{
			response=new Response(System.currentTimeMillis(),
					CommonConstants.SUCCESS_CODE,
					CommonConstants.SUCCESS
					);
			return response;
		}
	}


	
	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementService#getUser(java.lang.String)
	 */
	@Override
	public Response getUser(String userName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
			User user= dataSource.fetchUser(userName);
			logger.info("Fetched User from DB..........");
			if(user==null ){
				logger.info("User Present..........");
				throw new ResourceNotFoundException(CommonConstants.USER_NOT_FOUND_CODE, CommonConstants.USER_NOT_FOUND);
			}else{
				response=new Response(System.currentTimeMillis(),
						CommonConstants.SUCCESS_CODE,
						CommonConstants.SUCCESS,
						user);
				return response;
			}
		}
	
	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementService#getGroup(java.lang.String)
	 */
	@Override
	public Response getGroup(String groupName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
			UserGroup group= dataSource.fetchGroup(groupName);
			logger.info("Fetched User from DB..........");
			if(group==null ){
				logger.info("User Present..........");
				throw new ResourceNotFoundException(CommonConstants.GROUP_NOT_FOUND_CODE, CommonConstants.GROUP_NOT_FOUND);
			}else{
				response=new Response(System.currentTimeMillis(),
						CommonConstants.SUCCESS_CODE,
						CommonConstants.SUCCESS,
						group);
				return response;
			}
		}
	
	
	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementService#updateUser(com.springboot.usermanagement.beans.User)
	 */
	@Override
	public Response updateUser(UserGroup group) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
			Response response=new Response();
			dataSource.updateUser(group);
			logger.info("Fetched User from DB..........");
			return response;
		}

	}
	
		


