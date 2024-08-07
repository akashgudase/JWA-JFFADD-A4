package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO7 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static Query query;

	public static void main(String[] args) {
		openConnection();
		query = entityManager.createQuery("SELECT user FROM UserDTO user WHERE user.email = ?1 AND user.password = ?2");
		query.setParameter(1, "ramesh@gmail.com");
		query.setParameter(2, "Ramesh@1234");
		try {
			UserDTO user = (UserDTO) query.getSingleResult();
			System.out.println(user);
		} catch (NoResultException e) {
			System.out.println("Invalid email or password");
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
	}

}
