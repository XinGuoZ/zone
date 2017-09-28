package com.zone.essay.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zone.essay.entity.Essay;
import com.zone.essay.service.EssayService;
import com.zone.uitls.PageBean;

public class EssayAction extends ActionSupport implements ModelDriven<Essay>{

	private Essay essay=new Essay();//模型驱动
	private EssayService essayService;
	private PageBean<Essay> pageBean;//创建PageBean的值
	private int page;//接受一个页面数
	/**
	 * @author Scott
	 * 添加内容
	 * */
	public String save(){
		essayService.save(essay);
		return "index";
	}
	
	public String findpage(){
		pageBean=essayService.findByPage(page ,essay.getUser().getUserid());
		
		return "index";
	}
	/**
	 * @author Scott
	 * 跳转到publish页面
	 * */
	public String publish(){
		
		return"publish";
	}
	/**
	 * @author Scott
	 * 删除文章*/
	public String delete(){
		Essay delEssay=essayService.findByesid(essay.getEsid());
		essayService.delete(delEssay);
		this.addActionMessage("文章删除成功");
		return"msg";
	}
	
	public void setEssayService(EssayService essayService) {
		this.essayService = essayService;
	}

	public Essay getEssay() {
		return essay;
	}

	
	public PageBean<Essay> getPageBean() {
		return pageBean;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public Essay getModel() {
		// TODO Auto-generated method stub
		return essay;
	}

}
