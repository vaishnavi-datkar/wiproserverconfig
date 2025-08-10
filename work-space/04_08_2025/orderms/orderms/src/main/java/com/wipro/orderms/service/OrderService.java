package com.wipro.orderms.service;

import com.wipro.orderms.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);
   
	List<Order> findAll();
}
