package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.entity.Response;
import com.jspiders.springboot.entity.User;
import com.jspiders.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/users")
	protected ResponseEntity<Response<User>> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		Response<User> response = new Response<>();
		response.setMessage("User added");
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		response.setData(addedUser);
		return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
	}

}
