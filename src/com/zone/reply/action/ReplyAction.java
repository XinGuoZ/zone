package com.zone.reply.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zone.reply.entity.Reply;
import com.zone.reply.service.ReplyService;

public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {

	private Reply reply=new Reply();
	private ReplyService replyService;
	
	public void save(){
		replyService.save(reply);
	}
	
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	@Override
	public Reply getModel() {
		// TODO Auto-generated method stub
		return reply;
	}

}
