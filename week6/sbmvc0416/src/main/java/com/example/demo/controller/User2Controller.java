package com.example.demo.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User2;
import java.util.*;

@RestController
@RequestMapping("/user2")
public class User2Controller implements CommandLineRunner {
	 static List<User2> userList=new ArrayList<>();
	
	 @GetMapping("/{id}")
	    public User2 getUserById(@PathVariable String id) {
	        for (User2 user : userList) {
	            if (user.getId().equals(id)) {
	                return user;
	            }
	        }
	        return null;
	    }

	 @Override
	 public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 userList.add(new User2("1","Alan",20));
		 userList.add(new User2("2","Brite",25));
		 userList.add(new User2("1","Charlie",22));
	 }

}
