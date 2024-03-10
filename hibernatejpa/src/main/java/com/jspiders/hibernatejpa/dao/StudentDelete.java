package com.jspiders.hibernatejpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDelete {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		
		
	}

	public static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	public static void closeConnection() {
		
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
