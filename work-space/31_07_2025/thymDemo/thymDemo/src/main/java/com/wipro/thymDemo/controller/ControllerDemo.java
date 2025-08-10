package com.wipro.thymDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControllerDemo {

    @GetMapping("/show")
    public String showPage(Model model) {
        model.addAttribute("message", "Welcome to Thymeleaf!");
        model.addAttribute("name", "Vaishnavi");
        return "index"; 
    }
}
