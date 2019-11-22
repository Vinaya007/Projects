package com.springboot.usermanagement.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_groups")
@JsonIgnoreProperties(ignoreUnknown = true) 
public class UserGroup {	
	
	public UserGroup() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	private long id;
	@Column(name="group_name")
	private String groupName;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="group_id")
	private List<User> users=new ArrayList<User>();	
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/*public long getId() {
		return id;
	}*/
	public void setId(long id) {
		this.id = id;
	}
	
	

}
