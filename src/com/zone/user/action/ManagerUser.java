package com.zone.user.action;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zone.uitls.PageBean;
import com.zone.user.entity.User;
import com.zone.user.service.userService;

public class ManagerUser extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private userService userService;
	private Integer page=1;
	/**
	 * @author Scott
	 * 
	 * 全查*/
	public String findalluser(){
	
		PageBean< User> puser = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("puser",puser);
		return"findalluser";
	}
	/**
	 * @author Scott
	 * 删除*/
	public String delete(){
		User userdel=userService.findByUid(user.getUserid());
		if(deleteFile(userdel.getImgpath())){
			userService.delete(userdel);
			return"delsuc";
		}
		this.addActionMessage("用户删除成功");
			return"delfail";
	}
	
	/**
	 * @author Scott
	 * 单查
	 * */
	public String findByuid(){
		user=userService.findByUid(user.getUserid());
		return"findbyuid_suc";
	}
	
	/**
	 * @author Scott
	 * 修改
	 * */
	public String update(){
		User userinfo=userService.findByUid(user.getUserid());
		userinfo.setUstate(user.getUstate());
		userService.update(userinfo);
		return"delsuc";
	}
	
	public User getUser() {
		return user;
	}

	public void setUserService(userService userService) {
		this.userService = userService;
	}

	
	public void setPage(Integer page) {
		this.page = page;
	}

	//文件删除
	public boolean deleteFile(String sPath) {  
	    boolean flag = false;
	    String path = ServletActionContext.getServletContext().getRealPath(
	    		sPath);
	    File file = new File(path);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }else {
			return true;
		} 
	    return flag;  
	}  
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
