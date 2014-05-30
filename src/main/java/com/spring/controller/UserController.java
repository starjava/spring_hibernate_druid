package com.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.LoginCommand;
import com.spring.entity.User;
import com.spring.service.IUserService;

@Controller
@RequestMapping(value = "/admin")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login.html")
	public String loginPage() {
		return "pages/login";
	}

	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			LoginCommand loginCommand) {
		boolean isValidUser = userService.getMatchCount(
				loginCommand.getUsername(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("pages/login", "error", "用户名或密码错误");
		} else {
			User user = userService.findUserByUserName(loginCommand
					.getUsername());
			user.setLast_Ip(request.getRemoteAddr());
			user.setLast_visit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("pages/main");
		}
	}
}
