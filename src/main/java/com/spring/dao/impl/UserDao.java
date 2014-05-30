package com.spring.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.dao.IUserDao;
import com.spring.entity.User;

@Repository
public class UserDao implements IUserDao {

	@Resource
	private SessionFactory sessionFactory;

	public boolean getMatchCount(String uname, String password) {
		String sql = "select *from t_user where user_name='" + uname
				+ "' and password='" + password + "'";
		Session session=sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(sql);
		
		return null!=query.uniqueResult();
	}

	public User findUserByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateLoginInfo(int uid, Date date, String ip) {
		// TODO Auto-generated method stub

	}

}
