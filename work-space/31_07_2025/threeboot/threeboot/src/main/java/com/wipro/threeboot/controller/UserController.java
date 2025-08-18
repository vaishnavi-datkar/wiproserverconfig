package com.wipro.threeboot.controller;

import com.wipro.threeboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userreg";
    }

    @PostMapping("/submitUser")
    public String submitForm(@ModelAttribute("user") User user) {
                System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("Phone: " + user.getUserPhone());
        return "success"; 
    }
}
