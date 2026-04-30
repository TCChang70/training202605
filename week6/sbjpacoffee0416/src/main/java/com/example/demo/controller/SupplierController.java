package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;


@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	@Autowired
	SupplierRepository dao;
	
	@GetMapping()
	public List<Supplier> getAllSuppliers(){
	     return dao.findAll();	
	}
}
