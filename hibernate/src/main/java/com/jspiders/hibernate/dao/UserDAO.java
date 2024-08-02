package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1);
		userDTO.setName("Ram");
		userDTO.setEmail("ram@gmail.com");
		userDTO.setMobile(9876543210L);
		userDTO.setPassword("Ram@1234");
		
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		
	}

}
