package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
	@Query(value = "select * from customer where name = ?1", nativeQuery = true)
    Customer queryByName(String name);
	
	Customer findByName(String name);

}
