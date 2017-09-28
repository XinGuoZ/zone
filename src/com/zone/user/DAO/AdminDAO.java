package com.zone.user.DAO;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zone.user.entity.Admin;

public class AdminDAO extends HibernateDaoSupport {

	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		String hql="from Admin where Adminname=? and password=?";
		List<Admin> list=(List<Admin>) this.getHibernateTemplate().find(hql, admin.getAdminname(),admin.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
