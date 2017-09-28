package com.zone.essay.DAO;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zone.essay.entity.Essay;
import com.zone.uitls.PageHibernateCallback;

public class EssayDAO extends HibernateDaoSupport {
	/**
	 * @author Scott
	 * 保存一条记录
	*/
	public void save(Essay essay){
		this.getHibernateTemplate().save(essay);
	}
	/**
	*@author Scott
	*插叙记录数
	*/
	public int findCount(Integer userid){
		String hql="select count(*) from Essay";
		if(userid!=0){
			hql="select count(*) from Essay where user.userid="+userid+"";
		}
		
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * @author Scott
	 * 查询一页记录数*/
	public  List<Essay> findByPage(int begin,int limit,Integer userid){
		/*DetachedCriteria criteria=DetachedCriteria.forClass(Essay.class);
		List<Essay> list=(List<Essay>) this.getHibernateTemplate().findByCriteria(criteria,begin,limit);*/
		String hql;
		 hql="from Essay order by id desc";
		if(userid!=0){
			hql="from Essay where user.userid="+userid+" order by id desc";
		}
		
		List<Essay> list = null;
			list=this.getHibernateTemplate().execute(new PageHibernateCallback<Essay>(hql, null, begin, limit));
		return list;
	}
	
	public void delete(Essay entity){
		this.getHibernateTemplate().delete(entity);
	}
	public Essay findByesid(Integer esid) {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().get(Essay.class, esid);
	}
}
