package com.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.dao.ILoginLogDao;
import com.spring.dao.IUserDao;
import com.spring.entity.LoginLog;
import com.spring.entity.User;
import com.spring.service.IUserService;

@Service
public class UserService implements IUserService {
	public UserService(){}
	@Resource
	private IUserDao userdao;
	@Resource
	private ILoginLogDao loginlogdao;

	public boolean getMatchCount(String uname, String password) {
		return userdao.getMatchCount(uname, password);
	}

	public User findUserByUserName(String name) {
		return userdao.findUserByUserName(name);
	}

	public void loginSuccess(User user) {
		LoginLog loginlog = new LoginLog();
		loginlog.setUser_id(user.getUser_id());
		loginlog.setLogin_datetime(user.getLast_visit());
		loginlog.setIp(user.getLast_Ip());
		loginlogdao.insertLoginLog(loginlog);

	}

}
