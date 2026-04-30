package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import java.util.*;
@Controller
@RequestMapping("/users")
public class UserController {
	@GetMapping("/if-unless")
    public String ifUnless(Model model){
        User ramesh = new User("ramesh","ramesh@gmail.com", "ADMIN", "M");
        User admin = new User("admin","admin@gmail.com", "ADMIN", "M");
        User meena = new User("meena","meena@gmail.com", "USER", "F");
        List<User> users = new ArrayList<>();
        users.add(ramesh);
        users.add(admin);
        users.add(meena);
        model.addAttribute("users", users);
        return "if-unless";
    }
	@GetMapping("/switch-case")
    public String user(Model model){
        User user = new User("mary","mary@gmail.com", "MANAGER", "M");
        model.addAttribute("user", user);
        return "switch-case";
    }
	
	@GetMapping("/switch-case2")
    public String  case2(Model model){
        User ramesh = new User("ramesh","ramesh@gmail.com", "ADMIN", "M");
        User admin = new User("admin","admin@gmail.com", "MANAGER", "M");
        User meena = new User("meena","meena@gmail.com", "USER", "F");
        List<User> users = new ArrayList<>();
        users.add(ramesh);
        users.add(admin);
        users.add(meena);
        model.addAttribute("users", users);
        return "switch-case2";
    }
	
	@PostMapping("/modelpost")
    public String postuser(@ModelAttribute User u1,Model model){
        //User user = new User("mary","mary@gmail.com", "MANAGER", "M");
        model.addAttribute("user", u1);
        return "switch-case";
    }

}
