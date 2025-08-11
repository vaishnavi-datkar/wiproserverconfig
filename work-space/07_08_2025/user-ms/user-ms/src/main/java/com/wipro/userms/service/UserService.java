package com.wipro.userms.service;

import com.wipro.userms.entity.User;

import java.util.List;

public interface UserService {
    void save(User User);
   
	List<User> findAll();
}
