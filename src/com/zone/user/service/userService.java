package com.zone.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.Session;

import org.springframework.transaction.annotation.Transactional;

import com.zone.uitls.PageBean;
import com.zone.uitls.SendMailUtil;
import com.zone.uitls.UUIDUtils;
import com.zone.user.DAO.userDAO;
import com.zone.user.entity.User;
@Transactional
public class userService {

	
	private userDAO userDAO;//注入dao属性
	
	//按照用户名查询用户
	public User finByUsername(String username){
		return userDAO.findByUsername(username);
	}

	//业务层完成用户注册代码
	public void save(User user){
		//获取当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String time =sdf.format(new Date());
		user.setJoinin(time);
		user.setUstate("0");
		String code =UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDAO.save(user);
		SendMailUtil.send(user.getEmail(),"<a href='http://139.199.205.57/zone/user_active.action?code="+code+"'>用户点击此激活</a>'text/html;charset=utf-8'");
	}
	
	public void setUserDAO(userDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	// 业务层根据激活码查询用户
	public User findByCode(String code) {
		return userDAO.findByCode(code);
	}

	// 修改用户的状态的方法
	public void update(User existUser) {
		userDAO.update(existUser);
	}

	// 用户登录的方法
	public User login(User user) {
		return userDAO.login(user);
	}
	
	//业务层查询所以用户
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDAO.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<User> list = userDAO.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	
	public User findByUid(Integer uid) {
		return userDAO.findByUid(uid);
	}


	public void delete(User existUser) {
		userDAO.delete(existUser);
	}

	public List<User> findall() {
		// TODO Auto-generated method stub
		return userDAO.findall();
	}
}
