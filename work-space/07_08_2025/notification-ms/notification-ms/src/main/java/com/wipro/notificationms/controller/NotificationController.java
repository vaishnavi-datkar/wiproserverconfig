package com.wipro.notificationms.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.wipro.notificationms.entity.Notification;
import com.wipro.notificationms.service.NotificationService;

@RestController
@RequestMapping("/Notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    
   
    @PostMapping
	void save(@RequestBody Notification notification)
	{
		
		notificationService.save(notification);
		
		
	}

	@GetMapping
	List<Notification> findAll()
	{
		return notificationService.findAll();
	}
}