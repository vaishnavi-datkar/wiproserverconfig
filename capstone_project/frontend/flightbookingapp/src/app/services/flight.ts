import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Flight {
  private apiUrl = 'http://localhost:9999/api/flights';
  
   constructor(private http: HttpClient) { }
   searchFlights(source: string, destination: string, date: string): Observable<any[]> {
    const params = new HttpParams()
      .set('source', source)
      .set('destination', destination)
      .set('date', date);
    
    console.log('Calling backend API:', `${this.apiUrl}/search`, params);
     return this.http.get<any[]>(`${this.apiUrl}/search`, { params });
  }

  getAllFlights(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }
  
  getFlightById(flightId: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${flightId}`);
  }
}
