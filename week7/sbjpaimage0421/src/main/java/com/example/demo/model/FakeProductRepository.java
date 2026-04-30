package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FakeProductRepository extends JpaRepository<FakeProduct, Integer> {

}
