package com.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
			@RequestParam(name = "author") String author, ModelMap modelMap) {
		WebBlogDTO addedBlog = webBlogService.addBlog(title, content, author);
		if (addedBlog != null) {
			return "blogs";
		} else {
			modelMap.addAttribute("message", "Something went wrong..");
			return "add_blog";
		}
	}

}
