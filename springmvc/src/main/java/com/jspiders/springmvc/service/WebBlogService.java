package com.jspiders.springmvc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.WebBlogDAO;
import com.jspiders.springmvc.dto.WebBlogDTO;

@Component
public class WebBlogService {

	@Autowired
	private WebBlogDAO webBlogDAO;

	public WebBlogDTO addBlog(String title, String content, String author) {
		WebBlogDTO webBlog = new WebBlogDTO();
		webBlog.setTitle(title);
		webBlog.setContent(content);
		webBlog.setAuthor(author);
		webBlog.setDate(new Date(System.currentTimeMillis()));
		try {
			return webBlogDAO.addBlog(webBlog);
		} catch (Exception e) {
			return null;
		}
	}

}
