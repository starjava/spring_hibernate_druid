package com.spring.dao;

import java.util.Date;
import com.spring.entity.User;

/**
 * 用户在数据库中的相关操作
 * @author wangn
 *
 */
public interface IUserDao {

	/**
	 * 验证登录用户的帐号和密码是否正确
	 * @param uname 用户名
	 * @param password 密码
	 * @return true代表验证成功,false代表验证失败
	 */
	public boolean getMatchCount(String uname,String password);
	/**
	 * 根据username获取User对象
	 * @param name 用户名
	 * @return 返回user对象
	 */
	public User findUserByUserName(String name);
	/**
	 * 更新用户的最后一次的登录IP和最后一次的登录日期
	 * 
	 * @param uid
	 */
	public void updateLoginInfo( int uid,Date date,String ip);
}
