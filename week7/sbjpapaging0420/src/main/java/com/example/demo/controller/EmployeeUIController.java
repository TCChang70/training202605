package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.*;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.RecordNotFoundException;

@Controller
@RequestMapping("/thymeleaf")
public class EmployeeUIController {
	    @Autowired
	    EmployeeService service;
	 
	    @GetMapping("/employees")
	    public String getAllEmployees(
	                        @RequestParam(defaultValue = "0") Integer pageNo,
	                        @RequestParam(defaultValue = "5") Integer pageSize,
	                        @RequestParam(defaultValue = "employeeNumber") String sortBy,Model model)
	    {
	    	System.out.println("pageNo:"+pageNo);
	    	System.out.println("pageSize:"+pageSize);
	        List<Employee> list = service.getAllEmployees(pageNo, pageSize, sortBy);
	        model.addAttribute("employees", list);
	        return "list-employees";
	    }
	    @GetMapping("/edit")
	    public String addEmployee() throws RecordNotFoundException {	        
	        return "add-edit-employee";
	    }
	    @GetMapping("/edit/{id}")
	    public String getEmployeeById(@PathVariable("id") Integer id,Model model)
	                                                    throws RecordNotFoundException {
	        Employee entity = service.getEmployeeById(id);
	        model.addAttribute("employee", entity);
	        return "add-edit-employee";
	    }
	    @PostMapping("/createEmployee")
	    public String createOrUpdateEmployee(@ModelAttribute EmployeeForm form,Model model)
	                                                    throws RecordNotFoundException {
	        Employee found=service.getEmployeeById(form.getEmployeeNumber());
	        found.setEmail(form.getEmail());
	        found.setFirstName(form.getFirstName());
	        found.setLastName(form.getLastName());
	    	Employee updated = service.createOrUpdateEmployee(found);
	    	model.addAttribute("employee", updated);
	        return "add-edit-employee";
	    }    
}
