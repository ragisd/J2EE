package com.jspiders.OneToOne.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.OneToOne.DTO.PersonDTO;

public class PersonDTO_update {

	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id of person you want to update : ");
		int id = scanner.nextInt();
		
		PersonDTO person = entityManager.find(PersonDTO.class, id);
		
		person.setMobile(8123874398l);
		
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
