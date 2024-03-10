package com.jspiders.OneToOne.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.OneToOne.DTO.AadharcardDTO;
import com.jspiders.OneToOne.DTO.PersonDTO;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	
	public static void main(String[] args) {
		
		PersonDTO person = new PersonDTO();
		person.setName("nila");
		person.setAge(27);
		person.setEmail("nila@gmail.com");
		person.setMobile(9923437623l);
		
		openConnection();
		entityTransaction.begin();
		
		
		AadharcardDTO aadharcard = new AadharcardDTO();
		aadharcard.setAadharNo(9812339472234l);
		
		person.setAadharCard(aadharcard);
		
		entityManager.persist(aadharcard);
		entityManager.persist(person);
		
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
