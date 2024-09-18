package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.UserDAO;
import com.jspiders.springmvc.dto.UserDTO;

@Component
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public UserDTO addUser(String userName, String email, long mobile, String password) {
		UserDTO user = new UserDTO();
		user.setUserName(userName);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		try {
			return userDAO.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public UserDTO login(String email, String password) {
		try {
			return userDAO.login(email, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public UserDTO updateUser(int id, String userName, String email, long mobile, String password) {
		try {
			return userDAO.updateUser(id, userName, email, mobile, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

}
