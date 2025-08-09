package com.wipro.user.server;

import com.wipro.user.entity.User;
import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
}
