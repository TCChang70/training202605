package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;

import java.util.*;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
	
	@Autowired
	CoffeeRepostory dao;
	
	@GetMapping()
	public List<Coffee> getAllCoffees(){
	     return dao.findAll();	
	}

}
