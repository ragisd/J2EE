package com.jpsiders.OneToMany.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpsiders.OneToMany.DTO.EmployeeDTO;

public class CompanyDAO_update {

	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id of person you want to update : ");
		int id = scanner.nextInt();
		
		EmployeeDTO employee = entityManager.find(EmployeeDTO.class, id);
		
		if(employee != null) {
			employee.setMobileNo(8123874398l);
			
			entityManager.persist(employee);	
		}
		else
			System.out.println("No record with this Id present");
		
		
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
