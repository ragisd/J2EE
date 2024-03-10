package com.jspiders.ManyToMany.DAO;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.ManyToMany.DTO.CourseDTO;
import com.jspiders.ManyToMany.DTO.StudentDTO;

public class StudentDAO {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		StudentDTO student1 = new StudentDTO();
		student1.setName("maya");
		student1.setEmail("maya@gmail.com");
		
		StudentDTO student2 = new StudentDTO();
		student2.setName("raya");
		student2.setEmail("raya@gmail.com");
		
		CourseDTO course1 = new CourseDTO();
		course1.setName("SQL");
		course1.setFees(10000);
		
		CourseDTO course2 = new CourseDTO();
		course2.setName("Java");
		course2.setFees(13000);
		
		CourseDTO course3 = new CourseDTO();
		course2.setName("WebTech");
		course2.setFees(13000);
		
		
		student1.setCourses(Arrays.asList(course1, course2));
		student2.setCourses(Arrays.asList(course1, course3));

		openConnection();
		entityTransaction.begin();
				
		entityManager.persist(student1);
		entityManager.persist(student2);
		
		entityTransaction.commit();
		closeConnection();
		
		
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	

}
