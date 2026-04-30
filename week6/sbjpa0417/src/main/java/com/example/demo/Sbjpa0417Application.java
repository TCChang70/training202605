package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sbjpa0417Application {

	public static void main(String[] args) {
		SpringApplication.run(Sbjpa0417Application.class, args);
	}

}
