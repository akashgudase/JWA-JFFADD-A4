package com.jspiders.hibernate.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Doctor;
import com.jspiders.hibernate.dto.Patient;

public class DoctorDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Doctor doctor1 = new Doctor();
		doctor1.setName("Ramesh");
		doctor1.setSpeciality("Cardiologist");
		
		Doctor doctor2 = new Doctor();
		doctor2.setName("Suresh");
		doctor2.setSpeciality("Dermatologist");
		
		Patient patient1 = new Patient();
		patient1.setName("Mahesh");
		patient1.setDoctors(Arrays.asList(doctor1, doctor2));
		
		Patient patient2 = new Patient();
		patient2.setName("Umesh");
		patient2.setDoctors(Arrays.asList(doctor1, doctor2));
		
		doctor1.setPatients(Arrays.asList(patient1, patient2));
		
		doctor2.setPatients(Arrays.asList(patient1, patient2));
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(patient1);
		entityManager.persist(patient2);
		entityManager.persist(doctor1);
		entityManager.persist(doctor2);
		entityTransaction.commit();
		closeConnection();
		
		
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

}
