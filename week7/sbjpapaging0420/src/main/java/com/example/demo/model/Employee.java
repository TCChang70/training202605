package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {		
    @Id
    @Column(name="employeeNumber")
	private Integer employeeNumber;
	private String extension;
	private String firstName;
	private String officeCode;
	private String lastName;    
	private String email;	
	private Integer reportsTo;	
	private String jobTitle;

    //Setters, getters and toString()
}

