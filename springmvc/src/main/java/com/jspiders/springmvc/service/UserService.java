package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.UserDAO;
import com.jspiders.springmvc.dto.User;

@Component
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void addUser(String userName, String email, long mobile, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		userDAO.addUser(user);
	}

}
