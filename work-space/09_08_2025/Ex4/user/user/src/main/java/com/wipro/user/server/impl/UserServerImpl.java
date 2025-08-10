package com.wipro.user.server.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.user.entity.User;
import com.wipro.user.repo.UserRepo;
import com.wipro.user.server.UserService;

@Service
public class UserServerImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void save(User user) {
        userRepo.save(user);

        // Call to Notification MS after saving user
        String notificationUrl = "http://localhost:8082/notifications";
        restTemplate.postForObject(notificationUrl, user, String.class);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
