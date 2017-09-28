package com.zone.comment.entity;

import java.util.HashSet;
import java.util.Set;

import com.zone.essay.entity.Essay;
import com.zone.reply.entity.Reply;
import com.zone.user.entity.User;

public class Comment {

	private Integer comid;
	private String comment;
	private Essay essay;
	private Set<Reply> reply=new HashSet<Reply>();
	private User user;
	public Integer getComid() {
		return comid;
	}
	public void setComid(Integer comid) {
		this.comid = comid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Essay getEssay() {
		return essay;
	}
	public void setEssay(Essay essay) {
		this.essay = essay;
	}
	public Set<Reply> getReply() {
		return reply;
	}
	public void setReply(Set<Reply> reply) {
		this.reply = reply;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		
}
