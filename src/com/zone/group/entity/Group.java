package com.zone.group.entity;

import java.util.HashSet;
import java.util.Set;

import com.zone.friends.entity.Friends;
import com.zone.user.entity.User;

public class Group {

	private Integer grid;
	private String groupname;
	private String grstate;
	private User user;//与分组表形成多对一
	private Set<Friends> friends=new HashSet<Friends>();//与好友表形成一对多
	
	public Integer getGrid() {
		return grid;
	}
	public void setGrid(Integer grid) {
		this.grid = grid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getGrstate() {
		return grstate;
	}
	public void setGrstate(String grstate) {
		this.grstate = grstate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Friends> getFriends() {
		return friends;
	}
	public void setFriends(Set<Friends> friends) {
		this.friends = friends;
	}
	
	
}
