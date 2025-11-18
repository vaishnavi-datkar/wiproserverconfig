import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BookingService {
  
  // API Gateway URL for BookingMS endpoints
  // Gateway routes to BookingMS (port 9091)
  private apiUrl = 'http://localhost:9999/api/bookings';
  
  constructor(private http: HttpClient) {
    console.log('BookingService initialized');
  }
  
  
  createBooking(bookingData: any): Observable<any> {
    console.log('========================================');
    console.log('Creating booking:');
    console.log('URL:', `${this.apiUrl}/create`);
    console.log('Data:', bookingData);
    console.log('========================================');
    
    // POST request - sends data in request body as JSON
    return this.http.post<any>(`${this.apiUrl}/create`, bookingData);
  }
  
 
  initiatePayment(paymentData: any): Observable<any> {
    console.log('========================================');
    console.log('Initiating payment:');
    console.log('URL:', `${this.apiUrl}/payment`);
    console.log('Booking ID:', paymentData.bookingId);
    console.log('Amount:', paymentData.amount);
    console.log('Payment Method:', paymentData.paymentMethod);
    console.log('========================================');
    
    // POST request to initiate payment
    return this.http.post<any>(`${this.apiUrl}/payment`, paymentData);
  }
  
  
  getBookingById(bookingId: string): Observable<any> {
    console.log('Fetching booking status for:', bookingId);
    return this.http.get<any>(`${this.apiUrl}/${bookingId}`);
  }
  
  
  getAllBookings(): Observable<any[]> {
    console.log('Fetching all bookings');
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }
  
  
  pollBookingStatus(
    bookingId: string, 
    callback: (booking: any) => void, 
    maxAttempts: number = 30
  ): void {
    let attempts = 0;
    
    console.log('========================================');
    console.log('Starting payment status polling');
    console.log('Booking ID:', bookingId);
    console.log('Max attempts:', maxAttempts);
    console.log('========================================');
    
    // Set interval to check every 2 seconds
    const interval = setInterval(() => {
      attempts++;
      
      console.log(`Polling attempt ${attempts}/${maxAttempts}...`);
      
      // Get latest booking status from backend
      this.getBookingById(bookingId).subscribe({
        next: (booking) => {
          console.log(`Status: ${booking.status}`);
          
          // Check if payment is complete
          if (booking.status === 'SUCCESS' || booking.status === 'FAILED') {
            // Payment processed - stop polling
            clearInterval(interval);
            console.log('========================================');
            console.log('Payment complete! Status:', booking.status);
            console.log('========================================');
            callback(booking);
          }
          
          // Stop after max attempts even if still processing
          if (attempts >= maxAttempts) {
            clearInterval(interval);
            console.log('Max polling attempts reached. Stopping.');
            callback(booking);
          }
        },
        error: (error) => {
          console.error('Error polling booking status:', error);
          clearInterval(interval);
          callback(null);
        }
      });
    }, 2000); // Poll every 2 seconds
  }
}