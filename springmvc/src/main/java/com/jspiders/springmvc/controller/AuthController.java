package com.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	protected String getLogInPage() {
		return "login";
	}

	@RequestMapping("/signup")
	protected String getSignUpPage() {
		return "signup";
	}

	@RequestMapping("/users")
	protected void addUser(@RequestParam(name = "username") String userName, @RequestParam(name = "email") String email,
			@RequestParam(name = "mobile") long mobile, @RequestParam(name = "password") String password) {
		userService.addUser(userName, email, mobile, password);
	}

}
