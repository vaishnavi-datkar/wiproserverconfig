package com.wipro.bookingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.bookingapp.dto.Booking;
import com.wipro.bookingapp.entity.BookingApp;
import com.wipro.bookingapp.repo.BookingAppRepo;
import com.wipro.bookingapp.service.BookingAppService;
import com.wipro.bookingapp.util.AppConstant;

@Service
public class BookingAppServiceImpl implements BookingAppService {

    @Autowired
    BookingAppRepo bookingAppRepo;

    @Autowired
    KafkaTemplate<String, Booking> kafkaTemplate;

    @KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "app_uber")
    @Override
    public void acceptBookingOrder(Booking booking) {
        System.out.println("---Message Received by BookingApp---" + booking);

        // Logic to check if a ride should be accepted (e.g., driver available)
        boolean rideIsAccepted = booking.getVehicalNo() != null && !booking.getVehicalNo().isEmpty();

        BookingApp bookingApp = new BookingApp();
        bookingApp.setBookingId(booking.getBookingId());
        bookingApp.setVehicalNo(booking.getVehicalNo());
        bookingApp.setBookingAmount(booking.getBookingAmount());
        bookingApp.setRideStatus(false);
        if (rideIsAccepted) {
            System.out.println("Ride " + booking.getBookingId() + " accepted.");
            bookingApp.setRideStatus(true);
            booking.setRideStatus(true); // Update the DTO to send back
        } else {
            System.out.println("Ride " + booking.getBookingId() + " rejected.");
            bookingApp.setRideStatus(false);
            booking.setRideStatus(false); // Update the DTO to send back
        }

        bookingAppRepo.save(bookingApp);
        kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, booking);
    }

    @Override
    public void save(BookingApp bookingApp) {
        bookingAppRepo.save(bookingApp);
    }
}