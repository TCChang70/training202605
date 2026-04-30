package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {
	@Id
	@Column(name="employeenumber")
	private int employeeNumber;
	private String email;
	private String extension;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="officecode")
	private String officeCode;
	@Column(name="reportsto")
	private Integer reportsTo;
	@Column(name="jobtitle")
	private String jobTitle;
		
}