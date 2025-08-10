package com.wipro.orderms.service.impl;

import com.wipro.orderms.entity.Order;
import com.wipro.orderms.dto.Payment;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.service.OrderService;
import com.wipro.orderms.service.PaymentConnectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PaymentConnectService paymentConnectService;

    @Override
    @CircuitBreaker(name = "order-cb", fallbackMethod = "handleFallBack")
    public void save(Order order) {
        order.setOrderStatus("I");
        orderRepo.save(order); // insert

        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setPaymentId(order.getOrderValue()); // keeping your field
        payment.setPaymentStatus(true);

        ResponseEntity<Payment> response = paymentConnectService.savePaymentData(payment);

        if (response.getStatusCode() == HttpStatusCode.valueOf(200)) {
            order.setOrderStatus("P");
        }

        orderRepo.save(order); // update
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    // Fallback method must match parameters of save() + Throwable
    public void handleFallBack(Order order, Throwable t) {
        System.out.println("--System is down--");
        order.setOrderStatus("C");
        orderRepo.save(order);
    }
}
