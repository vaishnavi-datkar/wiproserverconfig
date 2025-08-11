package com.wipro.userms.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import com.wipro.userms.dto.Notification;


@FeignClient(name="notification-ms")
public interface NotificationConnectService {
	@PostMapping("/notification")
	ResponseEntity<Notification> saveNotificationData(@RequestBody Notification notification);
}
