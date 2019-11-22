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
import com.springboot.usermanagement.utility.CommonConstants;

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
	
	/**
	 * No Arg Constructor
	 */
	public UserManagementDao() {
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementDataSource#insertUser(com.springboot.usermanagement.beans.User)
	 */
	public Long insertUser(User user){
		Long integer=null;
		Session session=manager.unwrap(Session.class);
		integer=(Long)session.save(user);
		return integer;		
	}


	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementDataSource#insertGroup(com.springboot.usermanagement.beans.UserGroup)
	 */
	@Override
	public Long insertGroup(UserGroup newGroup) {
		// TODO Auto-generated method stub
		Long integer=null;
		Session session=manager.unwrap(Session.class);
		integer=(Long)session.save(newGroup);	
		return integer;
	}
	


	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementDataSource#fetchUser(java.lang.String)
	 */
	@Override
	public User fetchUser(String userName) {
		// TODO Auto-generated method stub
			Session session=manager.unwrap(Session.class);
			Query theQuery=session.createQuery(CommonConstants.FETCH_USER_QUERY);
			theQuery.setParameter("userName", userName);
			logger.info("The username is ...."+userName);
			User user=(User)theQuery.getSingleResult();	
			logger.info("The Name is ..."+user.getEmailId());
			return user;
	}	
	
	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementDataSource#fetchGroup(java.lang.String)
	 */
	@Override
	public UserGroup fetchGroup(String groupName) {
		// TODO Auto-generated method stub
			Session session=manager.unwrap(Session.class);
			Query theQuery=session.createQuery(CommonConstants.FETCH_GROUP_QUERY);
			theQuery.setParameter("groupName", groupName);
			logger.info("The groupName is ...."+groupName);
			UserGroup userGroup=(UserGroup)theQuery.getSingleResult();	
			logger.info("The Name is ..."+userGroup.getGroupName());
			logger.info("The Name is ..."+userGroup.getGroupName());
			return userGroup;
		}
	
	
	/* (non-Javadoc)
	 * @see com.springboot.usermanagement.interfaces.UserManagementDataSource#updateUser(com.springboot.usermanagement.beans.UserGroup)
	 */
	@Override
	public int updateUser(UserGroup group) {
		// TODO Auto-generated method stub
			Session session=manager.unwrap(Session.class);			
			Query theQuery=session.createSQLQuery(CommonConstants.UPDATE_USER_QUERY);
			logger.info("Group Name........"+group.getGroupName());
			theQuery.setParameter("groupName", group.getGroupName());
			theQuery.setParameter("userName", group.getUsers().get(0).getUserName());
			int rows=theQuery.executeUpdate();
			return rows;		
		}
}	



	
	
	
	

