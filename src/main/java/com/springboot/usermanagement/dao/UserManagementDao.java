package com.springboot.usermanagement.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.usermanagement.beans.User;
import com.springboot.usermanagement.beans.UserGroup;
import com.springboot.usermanagement.controller.UserManagementController;
import com.springboot.usermanagement.interfaces.UserManagementDataSource;

/**
 * @author vinaya.m
 *
 */
@Repository
@Transactional
public class UserManagementDao  implements UserManagementDataSource {
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired
	private EntityManager manager;
	
	public UserManagementDao() {
		// TODO Auto-generated constructor stub
	}

	
	public Long insertUser(User user){
		Long integer=null;
		Session session=manager.unwrap(Session.class);
		integer=(Long)session.save(user);
		return integer;		
	}


	@Override
	public Long insertGroup(UserGroup newGroup) {
		// TODO Auto-generated method stub
		Long integer=null;
		Session session=manager.unwrap(Session.class);
		integer=(Long)session.save(newGroup);	
		return integer;
	}
	


	@Override
	public User fetchUser(String userName) {
		// TODO Auto-generated method stub
			Session session=manager.unwrap(Session.class);
			Query theQuery=session.createQuery("select U from User U  where U.userName =: userName");
			theQuery.setParameter("userName", userName);
			logger.info("The username is ...."+userName);
			User user=(User)theQuery.getSingleResult();	
			logger.info("The Name is ..."+user.getEmailId());
			return user;
		}	
	
	@Override
	public UserGroup fetchGroup(String groupName) {
		// TODO Auto-generated method stub
			Session session=manager.unwrap(Session.class);
			Query theQuery=session.createQuery("select U from UserGroup U  where U.groupName =: groupName");
			theQuery.setParameter("groupName", groupName);
			logger.info("The groupName is ...."+groupName);
			UserGroup userGroup=(UserGroup)theQuery.getSingleResult();	
			logger.info("The Name is ..."+userGroup.getGroupName());
			logger.info("The Name is ..."+userGroup.getGroupName());
			return userGroup;
		}
	
	
	@Override
	public void updateUser(UserGroup user) {
		// TODO Auto-generated method stub
			Session session=manager.unwrap(Session.class);
			session.update(user);
		}
}	



	
	
	
	

