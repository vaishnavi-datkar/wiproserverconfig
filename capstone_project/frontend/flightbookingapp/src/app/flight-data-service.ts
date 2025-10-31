import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlightDataService {
private apiUrl = 'http://localhost:9999/flight-data'; // Through API Gateway
  http: any;
  
  searchFlights(source: string, destination: string, date: string) {
    return this.http.get(`${this.apiUrl}/search`, {
      params: { source, destination, date }
    });
  }
}
