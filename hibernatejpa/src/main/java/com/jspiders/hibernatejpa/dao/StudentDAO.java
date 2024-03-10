package com.jspiders.hibernatejpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatejpa.dto.StudentDTO;

public class StudentDAO {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {

		openConnection();
		entityTransaction.begin();

		StudentDTO student = new StudentDTO();
		student.setId(2);
		student.setName("meet");
		student.setMobile(9886443929l);
		student.setEmail("meet@gmail.com");
		student.setAge(25);
		

		entityManager.persist(student);

		entityTransaction.commit();
		closeConnection();
		
		
		
	}

	public static void openConnection() {
		entityManagerFactory = 	Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	public static void closeConnection() {
		
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
