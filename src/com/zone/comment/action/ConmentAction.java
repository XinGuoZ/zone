package com.zone.comment.action;

import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zone.comment.entity.Comment;
import com.zone.comment.service.CommentService;

public class ConmentAction extends ActionSupport implements ModelDriven<Comment> {
	private Comment comment=new Comment();//模型驱动
	private CommentService commentService;//注入属性
	
	
	
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
		
	}
	/**
	 * @author Scott
	 * 添加评论记录
		
		*/
	public String save(){
		commentService.save(comment);
		return"index";
	}

	/**
	 * @author Scott
	 * 查询所有评论
	 */

	@Override
	public Comment getModel() {
		// TODO Auto-generated method stub
		return comment;
	}

}
