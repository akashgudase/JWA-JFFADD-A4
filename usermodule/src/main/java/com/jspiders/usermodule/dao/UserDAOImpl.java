package com.jspiders.usermodule.dao;

import java.util.List;

import com.jspiders.usermodule.dto.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(String email, long mobile, String role, String password) {
		
	}

	@Override
	public void deleteUser(long id) {

	}

	@Override
	public void updateUser(long id, String email, long mobile, String role, String password) {

	}

	@Override
	public User findUserById(long id) {
		return null;
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		return null;
	}

	@Override
	public User findUserByMobileAndPassword(long mobile, String password) {
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		return null;
	}

}
