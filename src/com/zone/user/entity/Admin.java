package com.zone.user.entity;

public class Admin {

	private Integer adminid;
	private String Adminname;
	private String password;
	private Integer state;
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return Adminname;
	}
	public void setAdminname(String adminname) {
		Adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
