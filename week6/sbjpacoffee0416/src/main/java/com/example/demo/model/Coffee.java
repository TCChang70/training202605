package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="coffees")
@EqualsAndHashCode(exclude = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
   
	@Id
	@Column(name="COF_NAME")
	String cofName;
	//@Column(name="SUP_ID")
	//int supId;
	BigDecimal price;
	int sales;
	int total;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SUP_ID", nullable = false , referencedColumnName ="SUP_ID")
    Supplier supplier; 
	
}
