package com.wipro.bookingms.dto;
import java.time.LocalDate;

import lombok.Data;
@Data
public class BookingRequest {
	private String flightId;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private Double basePrice;
    private Double taxes;
    private Double totalAmount;

}
