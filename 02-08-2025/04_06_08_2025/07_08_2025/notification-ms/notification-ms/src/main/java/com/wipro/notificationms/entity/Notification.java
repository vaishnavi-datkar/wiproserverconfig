package com.wipro.notificationms.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="notification")
@Data

public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="user_name")
	String userName;
		 
	@Column(name="Notification_status")
	boolean NotificationStatus;
	
	@Column(name="Notification_")
	double NotificationAmount;
	

   

   
}
