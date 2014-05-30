package com.spring.entity;

import java.io.Serializable;
import java.util.Date;

import com.spring.util.DateUtil;


public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_name;
	private String password;
	private String last_Ip;
	private Date last_visit;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getLast_visit() {
		return last_visit;
	}

	public void setLast_visit(Date last_visit) {
		this.last_visit = last_visit;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLast_Ip() {
		return last_Ip;
	}

	public void setLast_Ip(String last_Ip) {
		this.last_Ip = last_Ip;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "userId=" + user_id + ",username=" + user_name + ",password="
				+ password + ",lastIp=" + last_Ip + ",last_Visit="
				+ DateUtil.DateFormat(this.getLast_visit());
	}
}
