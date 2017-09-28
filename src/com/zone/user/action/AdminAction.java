package com.zone.user.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zone.user.entity.Admin;
import com.zone.user.service.AdminService;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	Admin admin=new Admin();
	private AdminService adminService;
	
	public String login(){
		Admin adminsuc=adminService.login(admin);
		if(adminsuc == null){
			return "loginFail";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("admin", adminsuc);
		}
		return"loginscu";
	}
	
	/**
	 * @author Scott
	 * 用户退出的方法
	 */
	public String quit(){
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}
	
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	

	
}
