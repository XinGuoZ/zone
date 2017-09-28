package com.zone.comment.DAO;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zone.comment.entity.Comment;

public class CommentDAO extends HibernateDaoSupport{

	public void save(Comment comment) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(comment);
	}

	public List<Comment> findall() {
		// TODO Auto-generated method stub
		String hql="from Comment";
		return (List<Comment>) this.getHibernateTemplate().find(hql);
	}

}
