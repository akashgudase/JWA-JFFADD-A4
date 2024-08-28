package com.jspiders.usermodule.dao;

import java.util.List;

import com.jspiders.usermodule.dto.User;

public interface UserDAO {

	void addUser(String email, long mobile, String role, String password);

	void deleteUser(long id);

	void updateUser(long id, String email, long mobile, String role, String password);

	User findUserById(long id);

	User findUserByEmailAndPassword(String email, String password);

	User findUserByMobileAndPassword(long mobile, String password);

	List<User> findAllUsers();

}
