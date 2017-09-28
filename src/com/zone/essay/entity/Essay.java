package com.zone.essay.entity;


import java.util.HashSet;
import java.util.Set;

import com.zone.comment.entity.Comment;
import com.zone.user.entity.User;

public class Essay {

	private Integer esid;
	private String essay;
	private String date;
	private Integer userid;
	private Integer click;
	private Integer laud;
	private  String estate;
	private Set<Comment> comment= new HashSet<Comment>();
	private User user;
	
	
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getEsid() {
		return esid;
	}
	public void setEsid(Integer esid) {
		this.esid = esid;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public Integer getLaud() {
		return laud;
	}
	public void setLaud(Integer laud) {
		this.laud = laud;
	}
	public String getEstate() {
		return estate;
	}
	public void setEstate(String estate) {
		this.estate = estate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
