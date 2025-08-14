package com.aurionpro.service;

import com.aurionpro.dao.UserDao;

public class UserService {
	private UserDao userDao;
	public UserService() {
		this.userDao = new UserDao();
	}
	public boolean checkCredintails(String uname,String upassword) {
		return userDao.checkCredintails(uname,upassword);
	}
}
