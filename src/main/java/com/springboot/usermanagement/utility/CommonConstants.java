package com.springboot.usermanagement.utility;

/**
 * @author vinaya.m
 *
 */
public  class CommonConstants {
	public static final String USER_NOT_FOUND="USER_NOT_FOUND";
	public static final String GROUP_NOT_FOUND="GROUP_NOT_FOUND";
	public static final String SUCCESS="SUCCESS";
	public static final String FAILURE="FAILURE";
	public static final String TECHNICAL_ERROR="TECHNICAL_ERROR";
	public static final int SUCCESS_CODE=200;
	public static final int USER_NOT_FOUND_CODE=201;
	public static final int GROUP_NOT_FOUND_CODE=202;
	public static final int TECHNICAL_ERROR_CODE=210;
	public static final int USER_DATA_NOT_FOUND_CODE = 203;
	public static final String USER_DATA_NOT_FOUND = "USER_DATA_NOT_FOUND";	
	public static final String FETCH_USER_QUERY="select U from User U  where U.userName =: userName";
	public static final String FETCH_GROUP_QUERY="select U from UserGroup U  where U.groupName =: groupName";
	public static final String UPDATE_USER_QUERY="update txnlog.users set group_id=(select group_id "
												  + "from txnlog.user_groups where group_name=:groupName)"
												  + " where user_name=:userName";
}
