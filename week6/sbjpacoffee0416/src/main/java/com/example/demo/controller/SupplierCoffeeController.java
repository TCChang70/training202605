package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import java.util.*;

@RestController
public class SupplierCoffeeController implements CommandLineRunner {
    @Autowired
    SupplierRepository dao;
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Supplier s1=new Supplier(10,"Grand Coffee Inc.","Taipei","Kung Yuan","TW","10000");
		Coffee c1=new Coffee("Big Coffee",new BigDecimal(20),10,20,s1);
		Coffee c2=new Coffee("Big Grande Coffee",new BigDecimal(50),15,25,s1);
		Set<Coffee> set=new HashSet<>();
		set.add(c1);
		set.add(c2);
		s1.setCoffees(set);
		dao.save(s1);
	}

}
