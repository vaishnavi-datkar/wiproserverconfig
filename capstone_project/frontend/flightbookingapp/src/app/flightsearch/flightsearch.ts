import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../flightservice';


@Component({
  selector: 'app-flightsearch',
  imports: [FormsModule, CommonModule],
  templateUrl: './flightsearch.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrl: './flightsearch.css'
})
export class Flightsearch implements OnInit {
  // Form fields
  source: string = '';
  destination: string = '';
  departureDate: string = '';
  message: string = '';
  isLoading: boolean = false; // Loading state for API call
  
  // Injected services
  router = inject(Router);
  flightService = inject(FlightService); // ← NEW: Inject FlightService

  // Autocomplete suggestions
  suggestionsSource: string[] = [];
  suggestionsDestination: string[] = [];
  sourceFocused: boolean = false;
  destinationFocused: boolean = false;

  // Available cities
  private allCities = [
    'Pune', 'Delhi', 'Mumbai', 'Akola', 'Kolkata', 
    'Chennai', 'Bangalore', 'Hyderabad', 'Ahmedabad', 'Amravati'
  ];
  
  ngOnInit(): void {
    // Set today's date as default and minimum
    this.departureDate = new Date().toISOString().substring(0, 10);
  }

 
  isFormValid(): boolean {
    return this.source.trim().length > 0 && 
           this.destination.trim().length > 0 &&
           this.departureDate.trim().length > 0;
  }

  
  swapLocations(): void {
    const currentSource = this.source;
    this.source = this.destination;
    this.destination = currentSource;
    this.clearSuggestions();
  }

 
  onCityInput(value: string, inputType: 'source' | 'destination'): void {
    const normalizedValue = value.trim().toLowerCase();
    
    if (normalizedValue.length >= 3) {
      const filteredCities = this.allCities.filter(city => 
        city.toLowerCase().startsWith(normalizedValue)
      );
      
      if (inputType === 'source') {
        this.suggestionsSource = filteredCities;
      } else {
        this.suggestionsDestination = filteredCities;
      }
    } else {
      if (inputType === 'source') {
        this.suggestionsSource = [];
      } else {
        this.suggestionsDestination = [];
      }
    }
  }

  
  selectSuggestion(city: string, inputType: 'source' | 'destination'): void {
    if (inputType === 'source') {
      this.source = city;
      this.suggestionsSource = [];
    } else {
      this.destination = city;
      this.suggestionsDestination = [];
    }
  }

  clearSuggestions(): void {
    setTimeout(() => {
      this.suggestionsSource = [];
      this.suggestionsDestination = [];
      this.sourceFocused = false;
      this.destinationFocused = false;
    }, 200);
  }

  searchFlights(): void {
    // Validate form
    if (!this.isFormValid()) {
      this.message = 'Please fill in all required information.';
      return;
    }

    // Clear previous messages and show loading
    this.message = '';
    this.isLoading = true;

    console.log('========================================');
    console.log('Searching flights from BACKEND API');
    console.log('Source:', this.source);
    console.log('Destination:', this.destination);
    console.log('Date:', this.departureDate);
    console.log('========================================');

    // Call backend API through FlightService
    this.flightService.searchFlights(this.source, this.destination, this.departureDate)
      .subscribe({
        // Success callback - API returned data
        next: (flights: string | any[]) => {
          console.log('✅ Flights received from backend:', flights);
          console.log('Number of flights:', flights ? flights.length : 0);
          this.isLoading = false;
          
          if (flights && flights.length > 0) {
            // Navigate to booking-list with real flight data
            this.router.navigate(['/booking-list'], {
              state: {
                flights: flights,               // ← Real data from backend!
                source: this.source,
                destination: this.destination,
                departureDate: this.departureDate,
              }
            });
          } else {
            // No flights found for this route/date
            this.message = 'No flights available for the selected route and date.';
          }
        },
        
        // Error callback - API call failed
        error: (error: { status: any; message: any; url: any; }) => {
          console.error('❌ Error searching flights:', error);
          console.error('Error details:', {
            status: error.status,
            message: error.message,
            url: error.url
          });
          
          this.isLoading = false;
          this.message = 'Error searching flights. Please check if backend is running and try again.';
        }
      });
  }
}