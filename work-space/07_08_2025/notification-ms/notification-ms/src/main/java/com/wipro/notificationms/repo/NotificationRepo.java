package com.wipro.notificationms.repo;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.notificationms.entity.Notification;  

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Integer> {}
