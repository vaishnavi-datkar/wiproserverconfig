package com.wipro.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.user.entity.User;
import com.wipro.user.server.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	 UserService userService;
	 @PostMapping
	    public void save(@RequestBody User user) {
	        userService.save(user);
	    }
	 @GetMapping
	    public List<User> findAll() {
	        return userService.findAll();
	    }
}
