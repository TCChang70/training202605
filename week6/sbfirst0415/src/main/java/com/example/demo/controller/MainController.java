package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/services")
public class MainController{
	
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "<h1>Hi!</h1>";
    }
    
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
    	return "Hello World";
    }
    
    @GetMapping("/show")    
    public String showHello() {
    	//return "redirect:/hello.html";
    	return "/hello.html";
    }
}

