package com.jspiders.hibernate.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.BankAccount;
import com.jspiders.hibernate.dto.Person;

public class PersonDAO3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setName("Suresh");
		person.setMobile(9876543211L);
		
		BankAccount account1 = new BankAccount();
		account1.setAccountNumber(123456782L);
		account1.setAccountBalance(10000.00);
		
		BankAccount account2 = new BankAccount();
		account2.setAccountNumber(123456783L);
		account2.setAccountBalance(10000.00);
		
		person.setBankAccounts(Arrays.asList(account1, account2));
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(account1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(account2);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		closeConnection();
		
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
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