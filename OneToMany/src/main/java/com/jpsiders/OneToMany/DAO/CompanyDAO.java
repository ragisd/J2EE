package com.jpsiders.OneToMany.DAO;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpsiders.OneToMany.DTO.CompanyDTO;
import com.jpsiders.OneToMany.DTO.EmployeeDTO;

public class CompanyDAO {

	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setMobileNo(9876543218l);
		employee1.setName("Rama");
		employee1.setAge(30);
		employee1.setEmail("rama@gmail.com");
		
		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setName("Maya");
		employee2.setAge(30);
		employee2.setEmail("maya@gmail.com");
		employee2.setMobileNo(9876543218l);
		
		EmployeeDTO employee3 = new EmployeeDTO();
		employee3.setMobileNo(9876543218l);
		employee3.setName("Mahesh");
		employee3.setAge(30);
		employee3.setEmail("mahesh@gmail.com");
		
		EmployeeDTO employee4 = new EmployeeDTO();
		employee4.setMobileNo(9876543218l);
		employee4.setName("Mayur");
		employee4.setAge(30);
		employee4.setEmail("mayur@gmail.com");
		
		CompanyDTO company = new CompanyDTO();
		company.setLocation("Pune");
		company.setName("Infosys");
		company.setEmployeeDTO(Arrays.asList(employee1, employee2, employee3, employee4));
		
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.persist(employee4);
		entityManager.persist(company);
		
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
