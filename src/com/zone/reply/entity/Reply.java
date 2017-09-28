package com.zone.reply.entity;

import com.zone.comment.entity.Comment;
import com.zone.user.entity.User;

public class Reply {

	private Integer reid;
	private String reply;
	private Integer uesrid;
	private Integer comid;
	private String restate;
	private User user;//与用户表形成一对多
	private Comment comment;//与评论表形成一对多
	public Integer getReid() {
		return reid;
	}
	public void setReid(Integer reid) {
		this.reid = reid;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Integer getUesrid() {
		return uesrid;
	}
	public void setUesrid(Integer uesrid) {
		this.uesrid = uesrid;
	}
	public Integer getComid() {
		return comid;
	}
	public void setComid(Integer comid) {
		this.comid = comid;
	}
	public String getRestate() {
		return restate;
	}
	public void setRestate(String restate) {
		this.restate = restate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
}
