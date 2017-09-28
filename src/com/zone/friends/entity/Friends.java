package com.zone.friends.entity;

import com.zone.group.entity.Group;

public class Friends {

	private Integer frid;
	private Integer grid;
	private String frname;
	private Integer usid;
	private String frstate;
	private Group group;//与分组表形成多对一
	
	public Integer getFrid() {
		return frid;
	}
	public void setFrid(Integer frid) {
		this.frid = frid;
	}
	public Integer getGrid() {
		return grid;
	}
	public void setGrid(Integer grid) {
		this.grid = grid;
	}
	public String getFrname() {
		return frname;
	}
	public void setFrname(String frname) {
		this.frname = frname;
	}
	public Integer getUsid() {
		return usid;
	}
	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public String getFrstate() {
		return frstate;
	}
	public void setFrstate(String frstate) {
		this.frstate = frstate;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	} 
	
	
}
