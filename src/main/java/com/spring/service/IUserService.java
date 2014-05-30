package com.spring.service;

import com.spring.entity.User;

public interface IUserService {
	
	/**
	 * 验证登录用户的帐号和密码是否正确
	 * 
	 * @param uname
	 *            用户名
	 * @param password
	 *            密码
	 * @return true代表验证成功,false代表验证失败
	 */
	public boolean getMatchCount( String uname, String password);

	/**
	 * 根据username获取User对象
	 * 
	 * @param name
	 *            用户名
	 * @return 返回user对象
	 */
	public User findUserByUserName( String name);

	/**
	 * 登录成功后将登录信息写入登录日志表
	 * 
	 * @param user
	 *            用户信息
	 */
	public void loginSuccess(User user);
}
