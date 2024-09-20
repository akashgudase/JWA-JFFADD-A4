package com.jspiders.springmvc.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.UserDAO;
import com.jspiders.springmvc.dao.WebBlogDAO;
import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.dto.WebBlogDTO;

@Component
public class WebBlogService {

	@Autowired
	private WebBlogDAO webBlogDAO;

	@Autowired
	private UserDAO userDAO;

	public WebBlogDTO addBlog(String title, String content, String author, HttpSession httpSession) {
		WebBlogDTO webBlog = new WebBlogDTO();
		webBlog.setTitle(title);
		webBlog.setContent(content);
		webBlog.setAuthor(author);
		webBlog.setDate(new Date(System.currentTimeMillis()));
		try {
			WebBlogDTO blog = webBlogDAO.addBlog(webBlog);
			UserDTO user = (UserDTO) httpSession.getAttribute("user");
			userDAO.mapBlogToUser(blog.getId(), user.getId());
			return blog;
		} catch (Exception e) {
			return null;
		}
	}

}
