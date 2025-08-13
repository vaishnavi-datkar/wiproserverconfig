package com.wipro.jwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CurrentTimeController {
    @GetMapping("getCurrentTime")
    public String getCurrentTime() {
        return "Current time is: " + new Date();
    }
}