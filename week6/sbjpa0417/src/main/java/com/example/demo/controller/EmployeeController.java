package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import java.util.*;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
   @Autowired
   EmployeeRepository dao;
   
   @GetMapping()
   public ResponseEntity<Object> getAllEmployees(){
	   List<Employee> data=dao.findAll();
	   if(data!=null && data.size()>0) {
		   return new ResponseEntity(data,HttpStatus.OK);
	   }else {
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	   }
   }
   
   @GetMapping("/{code}")
   public ResponseEntity<Object> findByOfficeCode(@PathVariable("code")String code){
	   List<Employee> data=dao.findByOfficeCode(code);
	   if(data!=null && data.size()>0) {
		   return new ResponseEntity(data,HttpStatus.OK);
	   }else {
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	   }
   }
   @GetMapping("/emp/{no}")
   public ResponseEntity<Object> findByReportsTo(@PathVariable("no")int no){
	   List<Employee> data=dao.findByReportsTo(no);
	   if(data!=null && data.size()>0) {
		   return new ResponseEntity(data,HttpStatus.OK);
	   }else {
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	   }
   }
   
}
