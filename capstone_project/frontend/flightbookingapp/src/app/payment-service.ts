import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = 'http://localhost:9999/payment'; // Through API Gateway
  http: any;
  
  processPayment(paymentData: any) {
    return this.http.post(`${this.apiUrl}/process`, paymentData);
  }
}
