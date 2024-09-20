package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	protected String getSignUpPage() {
		return "signup";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String getLogInPage() {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	protected String getHomePage(HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null) {
			return "home";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	protected String addUser(@RequestParam(name = "username") String userName,
			@RequestParam(name = "email") String email, @RequestParam(name = "mobile") long mobile,
			@RequestParam(name = "password") String password, @RequestParam(name = "role") String role,
			ModelMap modelMap) {
		UserDTO addedUser = userService.addUser(userName, email, mobile, password, role);
		if (addedUser != null) {
			modelMap.addAttribute("message", "User added..");
			return "login";
		} else {
			modelMap.addAttribute("message", "Something went wrong..");
			return "signup";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected String login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
			ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = userService.login(email, password);
		if (user != null) {
			httpSession.setAttribute("user", user);
			httpSession.setMaxInactiveInterval(30 * 24 * 60 * 60);
			return "home";
		} else {
			modelMap.addAttribute("message", "Invalid email or password..");
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	protected String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.GET)
	protected String getEditPage(HttpSession httpSession, ModelMap modelMap) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			modelMap.addAttribute("user", user);
			return "edit";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	protected String updateUser(@RequestParam(name = "id") int id, @RequestParam(name = "username") String userName,
			@RequestParam(name = "email") String email, @RequestParam(name = "mobile") long mobile,
			@RequestParam(name = "password") String password, ModelMap modelMap) {
		UserDTO updatedUser = userService.updateUser(id, userName, email, mobile, password);
		if (updatedUser != null) {
			modelMap.addAttribute("message", "User updated..");
		} else {
			modelMap.addAttribute("message", "Something went wrong..");
		}
		return "home";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	protected String deleteUser(HttpSession httpSession, ModelMap modelMap) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			userService.deleteUser(user.getId());
			modelMap.addAttribute("message", "User deleted..");
		}
		httpSession.invalidate();
		return "login";
	}

}
