import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
   private apiUrl = 'http://localhost:9999/booking'; // Through API Gateway
  http: any;
  
  createBooking(bookingData: any) {
    return this.http.post(`${this.apiUrl}/create`, bookingData);
}
}