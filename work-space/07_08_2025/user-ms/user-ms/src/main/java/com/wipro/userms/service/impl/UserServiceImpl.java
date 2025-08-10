package com.wipro.userms.service.impl;

import com.wipro.userms.dto.Notification;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepo;
import com.wipro.userms.service.NotificationConnectService;
import com.wipro.userms.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserRepo userRepo;

    @Autowired
     NotificationConnectService notificationConnectService;

    @Override
    @CircuitBreaker(name = "user-cb", fallbackMethod = "fallbackNotification")
    public void save(User user) {
        userRepo.save(user);

        Notification notification = new Notification();
        notification.setEmail(user.getUserName());
        notification.setMessage("Welcome, " + user.getUserName());

        ResponseEntity<Notification> response = notificationConnectService.saveNotificationData(notification);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Notification sent");
        }
    }

    public void fallbackNotification(User user, Throwable t) {
        System.out.println("Notification Service Down. User saved but notification not sent.");
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
