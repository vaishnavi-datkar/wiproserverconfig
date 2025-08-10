package com.wipro.notificationms.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.notificationms.entity.Notification;
import com.wipro.notificationms.repo.NotificationRepo;
import com.wipro.notificationms.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	NotificationRepo notificationRepo;

	@Override
	public void save(Notification notification) {
		// TODO Auto-generated method stub
		 notificationRepo.save(notification);
		
	}

	@Override
	public List<Notification> findAll() {
		// TODO Auto-generated method stub
		return notificationRepo.findAll();
	}

	
	
	
}
