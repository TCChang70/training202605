package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AppRepository extends JpaRepository<Apps, Long> {
	
	 List<Apps> findByAppName(String name);
}

