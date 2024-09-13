package com.jspiders.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.User;

@Component
public class UserDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public void addUser(User user) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		closeConnection();
	}

	private void openConnection() {
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
