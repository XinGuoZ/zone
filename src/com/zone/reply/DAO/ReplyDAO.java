package com.zone.reply.DAO;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zone.essay.entity.Essay;
import com.zone.reply.entity.Reply;

public class ReplyDAO extends HibernateDaoSupport {

	public void save(Reply reply) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(reply);
	}

	public List<Essay> findall() {
		// TODO Auto-generated method stub
		return (List<Essay>) this.getHibernateTemplate().find("from Reply");
	}

	
}
