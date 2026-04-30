package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "mobile")
@Data
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "mobile_name", length = 255)
	private String mobileName;
	
	@Column(name = "mobile_company", length = 255)
	private String mobileCompany;
	
	@OneToMany(mappedBy = "mobile", cascade = CascadeType.ALL, targetEntity=Apps.class 
			,fetch = FetchType.EAGER )
	private Set<Apps> apps;
    public Mobile() {}
	public Mobile(String name, String company) {
		mobileName=name;
		mobileCompany=company;
	}
	
}


 

