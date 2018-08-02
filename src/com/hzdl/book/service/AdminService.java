package com.hzdl.book.service;

import com.hzdl.book.dao.AdminDao;
import com.hzdl.book.dao.imp.AdminDaoImp;
import com.hzdl.book.entity.Admin;

public class AdminService {

	private AdminDao dao;

	public AdminService() {
		super();
		dao = new AdminDaoImp();
	}

	public Admin login(String name, String pwd) {
		return dao.getAdminByNameAndPwd(name, pwd);
	}

}
