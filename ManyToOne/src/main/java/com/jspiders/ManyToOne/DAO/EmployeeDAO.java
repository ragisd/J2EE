package com.jspiders.ManyToOne.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDAO {

	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		
		
		entityTransaction.commit();
		closeConnection();
		
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		
		if(entityManager != null) {
			entityManager.close();
		}
		
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
	
}
