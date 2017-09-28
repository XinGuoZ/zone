package com.zone.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.zone.user.DAO.AdminDAO;
import com.zone.user.entity.Admin;
@Transactional
public class AdminService {

	private AdminDAO adminDAO;

	
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.login(admin);
	}


}
