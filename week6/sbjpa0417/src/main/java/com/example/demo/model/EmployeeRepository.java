package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
    List<Employee> findByOfficeCode(String code);
    List<Employee> findByReportsTo(int no);
}
