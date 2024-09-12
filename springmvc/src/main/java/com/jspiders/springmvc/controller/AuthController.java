package com.jspiders.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	protected String getLogInPage() {
		return "login";
	}
	
	@RequestMapping("/signup")
	protected String getSignUpPage() {
		return "signup";
	}

}
