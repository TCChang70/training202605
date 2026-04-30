package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;

@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	MemberRepository memberAccount;

	@PostMapping(value = "/addMember")
	public ResponseEntity<Object> addMemberPage(@RequestBody Member m) {
		try {
			boolean f = memberAccount.save(m) != null ? true : false;
			if (f)
				return new ResponseEntity<>("Add Success", HttpStatus.OK);
			else
				return new ResponseEntity<>("Add Failed", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>("Add Failed " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
    public List<Member> showAllMemberPage(Model model){  			
        return memberAccount.findAll();
    }

}
