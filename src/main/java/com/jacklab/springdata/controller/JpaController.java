package com.jacklab.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacklab.springdata.entity.User;
import com.jacklab.springdata.repository.UserRepository;

@RestController
public class JpaController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		User user = userRepository.findById(id).get();
		return user;
	}
	
	@PostMapping("/user/add")
	public User insertUser(@RequestBody User user) {
		User obj = userRepository.save(user);
		return obj;
	}
}
