package com.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.WebBlogDTO;

@Component
public class WebBlogDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public WebBlogDTO addBlog(WebBlogDTO webBlog) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(webBlog);
		entityTransaction.commit();
		closeConnection();
		return webBlog;
	}

	@SuppressWarnings("unchecked")
	public List<WebBlogDTO> findAllWebBlogs() {
		openConnection();
		Query query = entityManager.createQuery("SELECT blogs FROM WebBlogDTO blogs");
		List<WebBlogDTO> blogs = query.getResultList();
		closeConnection();
		return blogs;
	}

	private void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		entityManagerFactory = Persistence.createEntityManagerFactory("springmvc");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}

		}
	}

}
