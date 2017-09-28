package com.zone.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zone.comment.entity.Comment;
import com.zone.comment.service.CommentService;
import com.zone.essay.entity.Essay;
import com.zone.essay.service.EssayService;
import com.zone.reply.service.ReplyService;
import com.zone.uitls.PageBean;
import com.zone.user.entity.User;
import com.zone.user.service.userService;

public class IndexAction extends ActionSupport{
	private EssayService essayService;
	private int page=1;//接受一个页面数
	private CommentService commentService;
	private userService userService;
	private ReplyService replyService;
	private Integer userid;
	
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public void setUserService(userService userService) {
		this.userService = userService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public void setEssayService(EssayService essayService) {
		this.essayService = essayService;
	}

	
	
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @author Scott
	 * 根据用户的id进行文章的查询
	 * */
	public String myessay(){
		ActionContext.getContext().getValueStack().set("userid", userid);
		ActionContext.getContext().getValueStack().set("username", (userService.findByUid(userid)).getUsername());
		
		PageBean<Essay> elist= (PageBean<Essay>) essayService.findByPage(page,userid);//查询所有文章的集合
		ActionContext.getContext().getSession().put("eslist", elist);//将文章存入session对象中
		List<Comment> comments=commentService.findall();
		ActionContext.getContext().getValueStack().set("comments", comments);//将值存入值栈中
		List<User> user=userService.findall();
		ActionContext.getContext().getValueStack().set("user", user);
		List<Essay> reply=replyService.findall();
		ActionContext.getContext().getValueStack().set("reply", reply);
		return "myessay";
		
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		PageBean<Essay> elist= (PageBean<Essay>) essayService.findByPage(page,0);//查询所有文章的集合
		ActionContext.getContext().getSession().put("elist", elist);//将文章存入session对象中
		List<Comment> comments=commentService.findall();
		ActionContext.getContext().getValueStack().set("comments", comments);//将值存入值栈中
		List<User> user=userService.findall();
		ActionContext.getContext().getValueStack().set("user", user);
		List<Essay> reply=replyService.findall();
		ActionContext.getContext().getValueStack().set("reply", reply);
		return "index";
	}

	
}
