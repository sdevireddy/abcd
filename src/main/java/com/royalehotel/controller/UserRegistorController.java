package com.royalehotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.royalehotel.model.User;
import com.royalehotel.service.UserService;

@RestController
public class UserRegistorController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
	// @PostMapping("/registration")
	public User registor(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	@GetMapping("/users") 
	public List<User> fetchUsers() {
		return userService.fetchUsers();
		
	}
	
}
