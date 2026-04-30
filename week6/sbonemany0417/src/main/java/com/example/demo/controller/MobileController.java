package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import java.util.*;

@RestController
@RequestMapping("/mobiles")
public class MobileController implements CommandLineRunner {
    @Autowired
    MobileRepository mb;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Mobile m1=new Mobile("MB1","ComapanyA");
		Apps a1=new Apps("App1",10,null);
		Apps a2=new Apps("App2",5,null);
		Set<Apps> set=new HashSet<>();
		a1.setMobile(m1);
		a2.setMobile(m1);
		set.add(a1);
		set.add(a2);
		m1.setApps(set);
		mb.save(m1);
	}
   
}
