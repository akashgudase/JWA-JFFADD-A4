package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO9 {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");

		EntityManager entityManager1 = entityManagerFactory.createEntityManager();

		UserDTO user1 = entityManager1.find(UserDTO.class, 1);
		System.out.println(user1);

		UserDTO user2 = entityManager1.find(UserDTO.class, 1);
		System.out.println(user2);

		EntityManager entityManager2 = entityManagerFactory.createEntityManager();

		UserDTO user3 = entityManager2.find(UserDTO.class, 1);
		System.out.println(user3);

		UserDTO user4 = entityManager2.find(UserDTO.class, 1);
		System.out.println(user4);

		EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("hibernate");

		EntityManager entityManager3 = entityManagerFactory2.createEntityManager();

		UserDTO user5 = entityManager3.find(UserDTO.class, 1);
		System.out.println(user5);

		UserDTO user6 = entityManager3.find(UserDTO.class, 1);
		System.out.println(user6);

	}

}
