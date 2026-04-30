package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
	@Id
	@Column(name="SUP_ID")
   int supId;
	@Column(name="SUP_NAME")
   String supName;
   String city;
   String street;
   @Column(columnDefinition="char(2)")
   String state;
   @Column(columnDefinition="char(5)")
   String zip;   
   @OneToMany(mappedBy = "supplier", 
		   cascade = CascadeType.ALL, targetEntity=Coffee.class)   
   public Set<Coffee>  coffees;
   
   public Supplier(int supId, String supName, String city, String street, String state, String zip) {	
	this.supId = supId;
	this.supName = supName;
	this.city = city;
	this.street = street;
	this.state = state;
	this.zip = zip;
   }
}
