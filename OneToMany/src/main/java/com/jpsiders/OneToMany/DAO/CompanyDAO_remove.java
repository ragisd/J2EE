package com.jpsiders.OneToMany.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpsiders.OneToMany.DTO.CompanyDTO;
import com.jpsiders.OneToMany.DTO.EmployeeDTO;

public class CompanyDAO_remove {

	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		openConnection();
		entityTransaction.begin();
		
		System.out.println("Enter the id of company : ");
		int company_id = scanner.nextInt();
		System.out.println("Enter the id of person you want to delete : ");
		int employee_id = scanner.nextInt();
		
		CompanyDTO company = entityManager.find(CompanyDTO.class, company_id);
		List<EmployeeDTO> employees = company.getEmployeeDTO();
		
		EmployeeDTO employeeToBeDeleted = null;
		
		for(EmployeeDTO employee : employees) {
			if(employee.getId() == employee_id) {
				employeeToBeDeleted = employee;
				break;
			}
		}
		
		employees.remove(employeeToBeDeleted);
		entityManager.remove(employeeToBeDeleted);
		
		//company.setEmployeeDTO(employees);
		entityManager.persist(company);
		
		
//		if(employee != null) {
//			entityManager.remove(employee);	
//			System.out.println("Record deleted successfully");
//		}
//		else
//			System.out.println("No record with this Id present");
		
		
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
