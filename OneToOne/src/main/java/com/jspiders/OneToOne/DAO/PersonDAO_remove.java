package com.jspiders.OneToOne.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.OneToOne.DTO.AadharcardDTO;
import com.jspiders.OneToOne.DTO.PersonDTO;

public class PersonDAO_remove {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		
		openConnection();
		entityTransaction.begin();
		
		PersonDTO person = entityManager.find(PersonDTO.class, 3);
		AadharcardDTO aadhar = person.getAadharCard();
		
		entityManager.remove(person);
		entityManager.remove(aadhar);
		
		
		entityTransaction.commit();
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("person");
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
