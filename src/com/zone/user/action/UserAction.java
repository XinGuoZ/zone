package com.zone.user.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zone.user.entity.User;
import com.zone.user.service.userService;
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user=new User();//模型驱动
	private userService userService;//注入service属性
	private String checkcode;//获取验证码
	private File imgfile;//上传文件
	private String imgfileFileName;
	private String imgfileContentType; //文件类型 
	
	/*
	 * 跳转到注册页面
	*/
	public String registPage(){
		return "registPage";
	}
	
	public String signInPage(){
		this.addActionError("登入失败：用户名或者密码错误或者未激活");
		return "signInPage";
	}
	/**
	 * @author Scott
	 * ajax异步验证
	
	*/
	public String findByName() throws Exception{
		User exitUser=userService.finByUsername(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if(exitUser!=null){
			response.getWriter().println("<font color='red'>用户名已存在</font>");
			
		}else{
			response.getWriter().println("<font color='red'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	/**
	 * @author Scott
	 * 登入方法
	*/
	public String login(){
		User existUser=userService.login(user);
		if(existUser==null){
			
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
		}
		return "loginSucess";
	}
	/**
	 * 注册页面
	 * @author Scott
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	public String regist() throws IOException{
		if(imgfile != null){
			String path = ServletActionContext.getServletContext().getRealPath(
								"/userhead");
			Random num=new Random();
			String FileName=String.valueOf(Math.abs(num.nextInt()))+imgfileFileName;
			File diskFile = new File(path + "/" + FileName);
						// 文件上传:
			FileUtils.copyFile(imgfile, diskFile);
				
			user.setImgpath("userhead/" + FileName);
		}
		
		// 从session中获得验证码的随机值:
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");


		//验证码
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码输入错误!");
			return "msg";
		}
		//保存数据
		userService.save(user);
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}
	
	/**
	 * @author Scott
	 * 用户激活的方法
	 */
	public String active() {
		// 根据激活码查询用户:
		User existUser = userService.findByCode(user.getCode());
		// 判断
		if (existUser == null) {
			// 激活码错误的
			this.addActionMessage("激活失败:激活码错误!");
		} else {
			// 激活成功
			// 修改用户的状态
			existUser.setUstate("1");
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "msg";
	}
	/**
	 * @author Scott
	 * 单查*/
	public String info(){
		user=userService.findByUid(user.getUserid());
		return"user_info";
	}
	/**
	 * @author Scott
	 * @throws IOException 
	 * 更新用户资料
	 * */
	
	public String update() throws IOException{
		User userinfo=userService.findByUid(user.getUserid());
		userinfo.setUsername(user.getUsername());
		if(imgfile != null){
			if(userinfo.getImgpath()==null||userinfo.getImgpath().equals("")){//如何用户的
				Random num=new Random();
				String FileName=String.valueOf(Math.abs(num.nextInt()))+imgfileFileName;
				userinfo.setImgpath("userhead/"+FileName);
			}
			String path = ServletActionContext.getServletContext().getRealPath(userinfo.getImgpath());
			File diskFile = new File(path);
						// 文件上传:
			FileUtils.copyFile(imgfile, diskFile);
				
		}
		userService.update(userinfo);
		this.addActionMessage("修改成功!");
		return"msg";
	} 
	/**
	 * @author Scott
	 * 用户退出的方法
	 */
	public String quit(){
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		this.addActionMessage("退出成功!");
		return "msg";
	}
	
	/**
	 * @author Scott
	 * get和set方法
	*/
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}


	public String getImgfileFileName() {
		return imgfileFileName;
	}

	public void setImgfileFileName(String imgfileFileName) {
		this.imgfileFileName = imgfileFileName;
	}

	public void setImgfileContentType(String imgfileContentType) {
		this.imgfileContentType = imgfileContentType;
	}

	public File getImgfile() {
		return imgfile;
	}

	public void setImgfile(File imgfile) {
		this.imgfile = imgfile;
	}

	public void setUserService(userService userService) {
		this.userService = userService;
	}

	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}



	public User getUser() {
		return user;
	}
	
}
