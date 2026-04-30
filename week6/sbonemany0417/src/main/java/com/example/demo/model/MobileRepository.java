package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
	List<Mobile> findByMobileName(String mName);
}

