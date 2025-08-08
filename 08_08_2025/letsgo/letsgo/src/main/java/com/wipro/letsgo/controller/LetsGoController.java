package com.wipro.letsgo.controller;

import com.wipro.letsgo.entity.LetsGo;
import com.wipro.letsgo.service.LetsGoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/move")
public class LetsGoController {

    @Autowired
    private LetsGoService letsGoService;

    @PostMapping
    public LetsGo saveMovement(@RequestBody LetsGo letsGo) {
        return letsGoService.saveMovement(letsGo);
    }
    
    @GetMapping
    public List<LetsGo> getAllOrders() {
        return letsGoService.findAll();
    }
}
