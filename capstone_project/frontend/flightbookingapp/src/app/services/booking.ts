import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class Booking {
  private apiUrl = 'http://localhost:9999/api/bookings';
  
  constructor(private http: HttpClient) { }

  createBooking(bookingData: any): Observable<any> {
    console.log('Creating booking:', bookingData);
    return this.http.post<any>(`${this.apiUrl}/create`, bookingData);
  }
  initiatePayment(paymentData: any): Observable<any> {
    console.log('Initiating payment:', paymentData);
    return this.http.post<any>(`${this.apiUrl}/payment`, paymentData);
  }

   getBookingById(bookingId: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${bookingId}`);
  }
   getAllBookings(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }

   pollBookingStatus(bookingId: string, callback: (booking: any) => void, maxAttempts: number = 30): void {
    let attempts = 0;
    
    const interval = setInterval(() => {
      attempts++;
       this.getBookingById(bookingId).subscribe({
        next: (booking) => {
          console.log(`Polling attempt ${attempts}: Status = ${booking.status}`);
          
          // Check if payment is complete (SUCCESS or FAILED)
          if (booking.status === 'SUCCESS' || booking.status === 'FAILED') {
            clearInterval(interval);
            callback(booking);
          }
        if (attempts >= maxAttempts) {
            clearInterval(interval);
            console.log('Max polling attempts reached');
            callback(booking);
          }
        },
        error: (error) => {
          console.error('Error polling booking status:', error);
          clearInterval(interval);
        }
      });
    }, 2000);
  }  
}
