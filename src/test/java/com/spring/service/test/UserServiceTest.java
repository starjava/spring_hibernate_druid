package com.spring.service.test;

import static org.junit.Assert.*;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring.entity.User;
import com.spring.service.IUserService;

/**
 * 测试UserService
 * 
 * @author Administrator
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
public class UserServiceTest {
	@Resource
	private IUserService userservice;

	@Test
	public void hasMatchUser() {
		boolean b1 = userservice.getMatchCount("admin", "123456");
		boolean b2 = userservice.getMatchCount("admin", "111111");
		assertTrue(b1);
		assertTrue(!b2);
	}

//	@Test
//	public void findUserByUserName() {
//		User u = userservice.findUserByUserName("admin");
//		assertNotNull(u);
//		System.out.println("u=" + u);
//		assertEquals(u.getUser_name(), "admin");
//		userservice.loginSuccess(u);
//	}
}
