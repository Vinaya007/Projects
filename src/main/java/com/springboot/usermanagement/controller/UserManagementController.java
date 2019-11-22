package com.springboot.usermanagement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.usermanagement.beans.Response;
import com.springboot.usermanagement.beans.User;
import com.springboot.usermanagement.beans.UserGroup;
import com.springboot.usermanagement.exceptions.ResourceNotFoundException;
import com.springboot.usermanagement.interfaces.UserManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(value="Flag Controller API")
public class UserManagementController {
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired()
	private UserManagementService service=null;
	
	/**
	 * End Point to create User
	 * @return response
	 * @throws Exception 
	 */
	@PostMapping("/createUser")
	public Response createUser(@RequestBody User newUser) throws Exception{	
		return service.createUser(newUser);
	}
	
	/**
	 * End Point to create a Group
	 * @return response
	 * @throws Exception 
	 */
	@PostMapping("/createGroup")
	public Response createGroup(@RequestBody UserGroup newGroup) throws Exception{	
		return service.createGroup(newGroup);
	}
	
	
	/**
	 * End Point to search/fetch a User from DB 
	 * @return response
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getUser/{userName}")
	public Response getUser(@PathVariable String userName) throws ResourceNotFoundException{	
		logger.info("The Field is #############...."+userName);
		return service.getUser(userName);
	}
	
	/**
	 * End Point to fetch a Group and its User details from the DB
	 * @return response
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getGroup/{groupName}")
	public Response getGroup(@PathVariable String groupName) throws ResourceNotFoundException{	
		logger.info("The Field is #############...."+groupName);
		return service.getGroup(groupName);
	}
	
	
	/**
	 * End Point to add a User to a Group.
	 * @return response
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("api/updateUser")
	public Response updateUser(@RequestBody UserGroup group) throws ResourceNotFoundException{	
		logger.info("The Field is #############....");
		return service.updateUser(group);
	}
}
