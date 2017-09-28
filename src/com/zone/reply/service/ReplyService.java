package com.zone.reply.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zone.essay.entity.Essay;
import com.zone.reply.DAO.ReplyDAO;
import com.zone.reply.entity.Reply;

@Transactional
public class ReplyService {

	private ReplyDAO replyDAO;
	
	public void save(Reply reply) {
		// TODO Auto-generated method stub
		replyDAO.save(reply);
	}

	public List<Essay> findall() {
		// TODO Auto-generated method stub
		return replyDAO.findall();
	}

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	
}
