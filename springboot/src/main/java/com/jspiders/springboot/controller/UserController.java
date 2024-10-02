package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.entity.Response;
import com.jspiders.springboot.entity.User;
import com.jspiders.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/user")
	protected ResponseEntity<Response<User>> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		Response<User> response = new Response<>();
		response.setMessage("User added");
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		response.setData(addedUser);
		return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/user")
	protected ResponseEntity<Response<User>> updateUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		Response<User> response = new Response<>();
		response.setMessage("User updated");
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		response.setData(updatedUser);
		return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
	}

	@GetMapping(value = "/user/{id}")
	protected ResponseEntity<Response<User>> findUserById(@PathVariable(name = "id") int id) {
		User user = userService.findUserById(id);
		Response<User> response = new Response<>();
		if (user != null) {
			response.setMessage("User found");
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			response.setData(user);
			return new ResponseEntity<Response<User>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("User not found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/user/email")
	protected ResponseEntity<Response<User>> findUserByEmailAndPassword(@RequestBody User user) {
		User user1 = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Response<User> response = new Response<>();
		if (user1 != null) {
			response.setMessage("User found");
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			response.setData(user1);
			return new ResponseEntity<Response<User>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("User not found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/users")
	protected ResponseEntity<Response<User>> deleteUser(@RequestParam(name = "id") int id) {
		User deletedUser = userService.deleteUser(id);
		Response<User> response = new Response<>();
		response.setMessage("User deleted");
		response.setHttpStatusCode(HttpStatus.OK.value());
		response.setData(deletedUser);
		return new ResponseEntity<Response<User>>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/users")
	protected ResponseEntity<Response<List<User>>> findAllUsers() {
		List<User> users = userService.findAllUsers();
		Response<List<User>> response = new Response<>();
		if (users.size() > 0) {
			response.setMessage("Users found");
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			response.setData(users);
			return new ResponseEntity<Response<List<User>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("Users not found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(users);
			return new ResponseEntity<Response<List<User>>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/user/mobile")
	protected ResponseEntity<Response<User>> findUserByMobileAndPassword(@RequestBody User user) {
		User user2 = userService.findUserByMobileAndPassword(user.getMobile(), user.getPassword());
		Response<User> response = new Response<>();
		if (user2 != null) {
			response.setMessage("User found");
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			response.setData(user2);
			return new ResponseEntity<Response<User>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("User not found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping(value = "/user/product")
	protected ResponseEntity<Response<User>> mapProductToUser(@RequestParam(name = "user_id") int userId,
			@RequestParam(name = "product_id") int productId) {
		User user = userService.mapProductToUser(userId, productId);
		Response<User> response = new Response<>();
		response.setMessage("Product mapped to user");
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
	}

}
