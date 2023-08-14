package com.reset.SpringSecuritywithdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reset.SpringSecuritywithdb.entity.User;
import com.reset.SpringSecuritywithdb.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private UserRepository userrepository;
	
	
	@GetMapping("/home")
	public String home() {
		return "I am the Home Page";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "I am the Admin Page";
	}
	
	@PostMapping("/user")
	public String saveuser(@RequestBody User user) {
		userrepository.save(user);
		return "added user" + user+"succesfully";
	}
}
