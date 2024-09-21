package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.dto.WebBlogDTO;
import com.jspiders.springmvc.service.WebBlogService;

@Controller
public class WebBlogController {

	@Autowired
	private WebBlogService webBlogService;

	@RequestMapping(value = "/add-blog-page", method = RequestMethod.GET)
	protected String getAddBlogPage() {
		return "add_blog";
	}

	@RequestMapping(value = "/add-blog", method = RequestMethod.POST)
	protected String addBlog(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content,
			@RequestParam(name = "author") String author, ModelMap modelMap, HttpSession httpSession) {
		WebBlogDTO addedBlog = webBlogService.addBlog(title, content, author, httpSession);
		if (addedBlog != null) {
			List<WebBlogDTO> blogs = webBlogService.findAllWebBlogs();
			if (blogs != null) {
				modelMap.addAttribute("blogs", blogs);
			} else {
				modelMap.addAttribute("message", "Blogs not found..");
			}
			return "blogs";
		} else {
			modelMap.addAttribute("message", "Something went wrong..");
			return "add_blog";
		}
	}

	@RequestMapping(value = "blogs", method = RequestMethod.GET)
	protected String findAllBlogs(ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			List<WebBlogDTO> blogs = webBlogService.findAllWebBlogs();
			if (blogs != null) {
				modelMap.addAttribute("blogs", blogs);
			} else {
				modelMap.addAttribute("message", "Blogs not found..");
			}
			modelMap.addAttribute("role", user.getRole());
			return "blogs";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "my-blogs", method = RequestMethod.GET)
	protected String findMyBlogs(ModelMap modelMap, HttpSession httpSession) {
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		if (user != null) {
			modelMap.addAttribute("blogs", user.getWebBlogs());
			return "my_blogs";
		} else {
			return "login";
		}
	}

}
