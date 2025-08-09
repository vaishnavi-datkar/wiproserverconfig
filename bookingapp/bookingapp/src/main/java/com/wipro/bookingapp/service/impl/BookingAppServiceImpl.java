package com.wipro.bookingapp.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.bookingApp.dto.Booking;
import com.wipro.bookingApp.entity.BookingApp;
import com.wipro.bookingApp.repo.BookingAppRepo;
import com.wipro.bookingApp.util.AppConstant;
import com.wipro.bookingapp.service.BookingAppService;
@Service
public class BookingAppServiceImpl implements BookingAppService{
	@Autowired
	BookingAppRepo bookingAppRepo;
	
	@Autowired
	KafkaTemplate kafkaTemplate;

	@KafkaListener(topics=AppConstant.INCOMING_TOPIC_NAME,groupId="app_uber")
	@Override
	public void accepteBookingOrder(Booking booking) {
		// TODO Auto-generated method stub
		System.out.println("---Message Received by bookingApp---"+booking);
		BookingApp bookingApp=bookingAppRepo.findByrideId(booking.getRideId());
		if(bookingApp.getAccBalance()>=upi.getTransAmount())
		{
			
			Double newBalance=bookingApp.getRideStatus() -booking.getBookingAmount() ;
			bookingApp.setRideStatus(newStatus);
			booking.setRideStatus(true);
			bookingAppRepo.save(bankAccount);
			kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME,booking);
		} 
		
	}

	@Override
	public void save(com.wipro.bookingapp.entity.BookingApp bookingApp) {
		// TODO Auto-generated method stub
		bookingAppRepo.save(bookingApp);
	}
	
	

}
