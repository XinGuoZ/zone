package com.zone.comment.service;

import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Transactional;

import com.zone.comment.DAO.CommentDAO;
import com.zone.comment.entity.Comment;

@Transactional //开启事物管理
public class CommentService {

	private CommentDAO commentDAO;

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public void save(Comment comment) {
		// TODO Auto-generated method stub
		
		commentDAO.save(comment);
	}

	public List<Comment> findall() {
		// TODO Auto-generated method stub
		return commentDAO.findall();
	}

	
}
