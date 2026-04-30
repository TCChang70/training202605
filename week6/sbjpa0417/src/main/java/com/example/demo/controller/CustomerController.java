package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController implements CommandLineRunner {
    @Autowired
    CustomerRepository dao;
	
    @GetMapping("/{name}")
    public ResponseEntity<Object> findByName(@PathVariable("name")String name){
    	Customer c1=dao.findByName(name);
    	if(c1!=null) {
    		return new ResponseEntity(c1,HttpStatus.OK);
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    }
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		dao.save(new Customer("Company A",(short)5,"Mary"));
//		dao.save(new Customer("Company B",(short)3,"John"));
//		dao.save(new Customer("Company C",(short)1,"George"));
//		dao.save(new Customer("Company D",(short)4,"Peter"));
//		dao.save(new Customer("Company E",(short)2,"Danny"));
//		dao.save(new Customer("Company F",(short)6,"Yen"));
	}
     
}
