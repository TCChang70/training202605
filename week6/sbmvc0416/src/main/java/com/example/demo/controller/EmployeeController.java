package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;

import java.util.*;

@Controller
@RequestMapping("/thymeleaf")
public class EmployeeController {
	
	@GetMapping("/iteration")
    public String iteration(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ramesh", "Fadatare", "ramesh@gmail.com"));
        employees.add(new Employee("John", "Cena", "john@gmail.com"));
        employees.add(new Employee("Tom", "Cruise", "tom@gmail.com"));
        employees.add(new Employee("Tony", "Stark", "tony@gmail.com"));
        model.addAttribute("employees", employees);
        return "iteration";
    }   

}
