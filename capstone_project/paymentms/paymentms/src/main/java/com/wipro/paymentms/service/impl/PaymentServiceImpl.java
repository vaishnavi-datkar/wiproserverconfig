package com.wipro.paymentms.service.impl;

import com.wipro.paymentms.dto.PaymentRequest;
import com.wipro.paymentms.dto.PaymentResponse;
import com.wipro.paymentms.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

/**
 * Implementation of PaymentService
 * Contains business logic for payment processing
 * @Service - Marks this as Spring service component
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    
    /**
     * Main method to process payment
     * Steps:
     * 1. Validate payment details based on payment method
     * 2. Simulate payment processing (80% success rate)
     * 3. Return success or failure response
     */
    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        try {
            System.out.println("Processing payment for booking: " + request.getBookingId());
            
            // Step 1: Validate payment details
            boolean isValid = validatePayment(request);
            
            if (!isValid) {
                // Return failure if validation fails
                return new PaymentResponse(
                    request.getBookingId(), 
                    "FAILED", 
                    "Invalid payment details. Please check and try again."
                );
            }
            
            // Step 2: Simulate payment processing
            // In real application, this would call payment gateway API
            // Using 80% success rate for simulation
            boolean paymentSuccess = Math.random() > 0.2;
            
            if (paymentSuccess) {
                // Payment successful
                System.out.println("Payment SUCCESS for booking: " + request.getBookingId());
                return new PaymentResponse(
                    request.getBookingId(), 
                    "SUCCESS", 
                    "Payment processed successfully"
                );
            } else {
                // Payment failed (simulated failure)
                System.out.println("Payment FAILED for booking: " + request.getBookingId());
                return new PaymentResponse(
                    request.getBookingId(), 
                    "FAILED", 
                    "Payment processing failed. Please try again."
                );
            }
            
        } catch (Exception e) {
            // Handle any unexpected errors
            System.err.println("Payment processing error: " + e.getMessage());
            return new PaymentResponse(
                request.getBookingId(), 
                "FAILED", 
                "Payment processing error: " + e.getMessage()
            );
        }
    }
    
    /**
     * Validates payment based on payment method
     * Calls specific validation method for card or UPI
     */
    private boolean validatePayment(PaymentRequest request) {
        String paymentMethod = request.getPaymentMethod().toLowerCase();
        
        if ("card".equals(paymentMethod)) {
            return validateCardPayment(request);
        } else if ("upi".equals(paymentMethod)) {
            return validateUpiPayment(request);
        }
        
        // Invalid payment method
        return false;
    }
    
    /**
     * Validates card payment details
     * Checks:
     * 1. Card number is 16 digits
     * 2. Expiry date is in MM/YY format and is a future date
     * 3. CVV is 3 digits
     */
    private boolean validateCardPayment(PaymentRequest request) {
        // Validate card number (must be 16 digits)
        String cardNumber = request.getCardNumber();
        if (cardNumber == null || cardNumber.replaceAll("\\s", "").length() != 16) {
            System.out.println("Validation failed: Invalid card number length");
            return false;
        }
        
        // Validate expiry date (MM/YY format and future date)
        String expiryDate = request.getExpiryDate();
        if (expiryDate == null || !expiryDate.matches("\\d{2}/\\d{2}")) {
            System.out.println("Validation failed: Invalid expiry date format");
            return false;
        }
        
        try {
            // Parse expiry date
            String[] parts = expiryDate.split("/");
            int month = Integer.parseInt(parts[0]);
            int year = 2000 + Integer.parseInt(parts[1]);
            
            // Check if month is valid (1-12)
            if (month < 1 || month > 12) {
                System.out.println("Validation failed: Invalid month");
                return false;
            }
            
            // Check if expiry date is in future
            YearMonth expiryYearMonth = YearMonth.of(year, month);
            YearMonth currentYearMonth = YearMonth.now();
            
            if (expiryYearMonth.isBefore(currentYearMonth) || expiryYearMonth.equals(currentYearMonth)) {
                System.out.println("Validation failed: Card expired");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Validation failed: Error parsing expiry date");
            return false;
        }
        
        // Validate CVV (must be 3 digits)
        String cvv = request.getCvv();
        if (cvv == null || !cvv.matches("\\d{3}")) {
            System.out.println("Validation failed: Invalid CVV");
            return false;
        }
        
        // All validations passed
        System.out.println("Card payment validation: SUCCESS");
        return true;
    }
    
    /**
     * Validates UPI payment details
     * Checks: UPI ID is in correct format (username@bank)
     */
    private boolean validateUpiPayment(PaymentRequest request) {
        String upiId = request.getUpiId();
        
        // Validate UPI ID format (must contain @ symbol)
        // Format: username@bank (e.g., john@paytm, user123@ybl)
        if (upiId == null || !upiId.matches("^[a-zA-Z0-9.\\-_]{2,}@[a-zA-Z]{2,}$")) {
            System.out.println("Validation failed: Invalid UPI ID format");
            return false;
        }
        
        // Validation passed
        System.out.println("UPI payment validation: SUCCESS");
        return true;
    }
}