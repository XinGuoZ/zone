package com.zone.user.entity;

import java.util.HashSet;
import java.util.Set;

import com.zone.comment.entity.Comment;
import com.zone.essay.entity.Essay;
import com.zone.group.entity.Group;
import com.zone.reply.entity.Reply;

public class User {

	private Integer userid;
	private String username;
	private String userpass;
	private String userboth;
	private String email;
	private String joinin;
	private String code;
	private String imgpath;
	private String ustate;
	private Set<Essay> essay=new HashSet<Essay>();//与文章表形成一对多
	private Set<Reply> reply=new HashSet<Reply>();
	private Set<Group> group=new HashSet<Group>();//与分组形成一对多
	private Set<Comment> comment=new HashSet<Comment>(); 
	
	public Set<Essay> getEssay() {
		return essay;
	}
	public void setEssay(Set<Essay> essay) {
		this.essay = essay;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserboth() {
		return userboth;
	}
	public void setUserboth(String userboth) {
		this.userboth = userboth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinin() {
		return joinin;
	}
	public void setJoinin(String joinin) {
		this.joinin = joinin;
	}
	public String getUstate() {
		return ustate;
	}
	public void setUstate(String ustate) {
		this.ustate = ustate;
	}
	public Set<Group> getGroup() {
		return group;
	}
	public void setGroup(Set<Group> group) {
		this.group = group;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Set<Reply> getReply() {
		return reply;
	}
	public void setReply(Set<Reply> reply) {
		this.reply = reply;
	}
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
	
}
