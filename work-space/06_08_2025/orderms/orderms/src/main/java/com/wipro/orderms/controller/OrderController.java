package com.wipro.orderms.controller;

import com.wipro.orderms.entity.Order;
import com.wipro.orderms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    void save(@RequestBody Order order) {
    	orderService.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }
}
