package com.wipro.userms.controller;

import com.wipro.userms.entity.User;
import com.wipro.userms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping
    void save(@RequestBody User user) {
    	UserService.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return UserService.findAll();
    }
}
