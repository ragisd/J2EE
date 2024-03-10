package com.jspiders.ManyToOne.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private long mobileNo;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false, unique = true)
	private String email;
	@ManyToOne
	private CompanyDTO company;

}
