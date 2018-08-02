package com.hzdl.book.service;

import com.hzdl.book.dao.UserDao;
import com.hzdl.book.dao.imp.UserDaoImp;

public class UserService {

	private UserDao dao;
	
	public UserService() {
		dao = new UserDaoImp();
	}
	
	public boolean checkUser(String userName) {
		return dao.exist(userName); 
	}
	
}
