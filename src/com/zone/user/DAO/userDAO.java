package com.zone.user.DAO;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zone.user.entity.User;

public class userDAO extends HibernateDaoSupport {

	//按名次查询是否有该用户
	public User findByUsername(String username){
		String hql="from User where username=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, username);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	
	//注册用户存入数据库代码实现
	public void save(User user){
		this.getHibernateTemplate().save(user);
	}
	
	//根据激活码找到用户
	public User findByCode(String code){
		String hql="from User where code=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, code);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	//修改游湖状态
	public void update(User exitUser){
		this.getHibernateTemplate().update(exitUser);
	}
	//用户登入的方法
	public User login(User user){
		
		String hql="from User where username=? and userpass=? and ustate=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getUserpass(),"1");
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	//查询总计录数
	public int findCount(){
		String hql="select count(*) from User";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	public User findByUid(Integer uid){
		return this.getHibernateTemplate().get(User.class, uid);
	}
	
	public void delete(User exitUser){
		this.getHibernateTemplate().delete(exitUser);
	}

	public List<User> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		List<User> list=(List<User>) this.getHibernateTemplate().findByCriteria(criteria,begin,limit);
		return list;
	}

	public List<User> findall() {
		// TODO Auto-generated method stub
		String hql="from User";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}
}
