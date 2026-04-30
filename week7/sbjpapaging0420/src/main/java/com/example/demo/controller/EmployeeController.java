package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.*;
import java.util.*;
import com.example.demo.model.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeService service;
 
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "employeeNumber") String sortBy)
    {
    	System.out.println("pageNo:"+pageNo);
    	System.out.println("pageSize:"+pageSize);
        List<Employee> list = service.getAllEmployees(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Employee>>(list,  HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        Employee entity = service.getEmployeeById(id);
 
        return new ResponseEntity<Employee>(entity,  HttpStatus.OK);
    } 
    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee)
                                                    throws RecordNotFoundException {
        Employee updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(updated,  HttpStatus.OK);
    }    
 
}
 

