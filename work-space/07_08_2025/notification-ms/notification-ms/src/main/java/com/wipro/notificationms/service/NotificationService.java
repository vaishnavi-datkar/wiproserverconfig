package com.wipro.notificationms.service;

import java.util.List;

import com.wipro.notificationms.entity.Notification;

 

public interface NotificationService {

	void save(Notification order);
	List<Notification> findAll();
}