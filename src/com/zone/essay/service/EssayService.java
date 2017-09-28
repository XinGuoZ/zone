package com.zone.essay.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.zone.essay.DAO.EssayDAO;
import com.zone.essay.entity.Essay;
import com.zone.uitls.PageBean;

@Transactional
public class EssayService {

	private EssayDAO essayDAO;//注入dao属性

	public void setEssayDAO(EssayDAO essayDAO) {
		
		this.essayDAO = essayDAO;
	}

	public void save(Essay essay) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time=sdf.format(new Date());
		essay.setDate(time);//设置时间
		essayDAO.save(essay);
	}
	
	public PageBean<Essay> findByPage(Integer page,Integer userid){
		PageBean<Essay> pageBean =new PageBean<Essay>();
		pageBean.setPage(page);//设置当前记录数
		int limit=12;
		pageBean.setLimit(limit);//设置每页的数量
		int totalCount=0;
		totalCount=essayDAO.findCount(userid);//查询总记录
		pageBean.setTotalCount(totalCount);//设置记录数
		int totalpage =0;
		totalpage=(totalCount/limit);
		if((totalCount%limit)!=0){
			totalpage=totalpage+1;
		}
		pageBean.setTotalpage(totalpage);
		int begin=(page-1)*limit;
		List<Essay> list=essayDAO.findByPage(begin, limit,userid);
		pageBean.setList(list);
		return pageBean;
	}

	public Essay findByesid(Integer esid) {
		// TODO Auto-generated method stub
		return essayDAO.findByesid(esid);
	}

	public void delete(Essay delEssay) {
		// TODO Auto-generated method stub
		essayDAO.delete(delEssay);
	}
	
}
