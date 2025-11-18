import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})

export class FlightService {
  
  // API Gateway URL - All requests go through gateway (port 9999)
  // Gateway routes to FlightDataMS (port 9090)
  private apiUrl = 'http://localhost:9999/api/flights';
  
  /**
   * Constructor injection of HttpClient
   * HttpClient is Angular's service for making HTTP requests
   */
  constructor(private http: HttpClient) { 
    console.log('FlightService initialized');
  }
  

  searchFlights(source: string, destination: string, date: string): Observable<any[]> {
    // Build query parameters
    // Result: ?source=Pune&destination=Delhi&date=2025-09-01
    const params = new HttpParams()
      .set('source', source)
      .set('destination', destination)
      .set('date', date);
    
    console.log('========================================');
    console.log('Calling Flight Search API:');
    console.log('URL:', `${this.apiUrl}/search`);
    console.log('Params:', { source, destination, date });
    console.log('========================================');
    
    // Make HTTP GET request
    // Angular automatically converts JSON response to JavaScript objects
    return this.http.get<any[]>(`${this.apiUrl}/search`, { params });
  }
  
  
  getAllFlights(): Observable<any[]> {
    console.log('Fetching all flights from:', `${this.apiUrl}/all`);
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }
  
  
  getFlightById(flightId: string): Observable<any> {
    console.log('Fetching flight:', flightId);
    return this.http.get<any>(`${this.apiUrl}/${flightId}`);
  }
}