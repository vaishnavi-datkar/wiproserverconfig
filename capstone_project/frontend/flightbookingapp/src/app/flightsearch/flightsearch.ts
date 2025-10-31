import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router} from '@angular/router';
import { Flight } from '../flight';

@Component({
  selector: 'app-flightsearch',
  imports: [FormsModule,CommonModule],
  templateUrl: './flightsearch.html',
   changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrl: './flightsearch.css'
})
export class Flightsearch  implements OnInit {
source: string = '';
  destination: string = '';
  departureDate: string = '';
  message: string = '';
  
  router = inject(Router);

  suggestionsSource: string[] = [];
  suggestionsDestination: string[] = [];
  sourceFocused: boolean = false;
  destinationFocused: boolean = false;

  private allCities = ['Pune', 'Delhi', 'Mumbai', 'Akola', 'Kolkata', 'Chennai', 'Bangalore', 'Hyderabad', 'Ahmedabad', 'Amravati'];
  
  ngOnInit(): void {
    // Set a default date on component initialization
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
    if (this.isFormValid()) {
      // Navigate to booking-list with search parameters
      this.router.navigate(['/booking-list'], {
        state: {
          source: this.source,
          destination: this.destination,
          departureDate: this.departureDate,
        }
      });
    } else {
      this.message = 'Please fill in all required information.';
    }
  }

  private generateMockFlights(): Flight[] {
    const departureHour = (time: string): number => {
      const hour = parseInt(time.split(':')[0]);
      const period = time.includes('PM') ? 12 : 0;
      return hour === 12 ? period : hour + period;
    };

    const isMorning = (time: string): boolean => {
      const hour = departureHour(time);
      return hour >= 6 && hour < 12;
    };

    const isLate = (time: string): boolean => {
      const hour = departureHour(time);
      return hour >= 18;
    };

    return [
      {
        id: 'FL123',
        flightNumber: 'FL123',
        airline: 'Gemini Air',
        departureTime: '08:00 AM',
        arrivalTime: '11:30 AM',
        price: '7120',
        source: this.source,
        destination: this.destination,
        departureHour: departureHour('08:00 AM'),
        stopType: 'Non-stop',
        isNonStop: true,
        isMorning: isMorning('08:00 AM'),
        isLate: isLate('08:00 AM'),
        duration: '3h 30m'
      },
      {
        id: 'FL456',
        flightNumber: 'FL456',
        airline: 'Indigo Airlines',
        departureTime: '01:00 PM',
        arrivalTime: '04:30 PM',
        price: '4310',
        source: this.source,
        destination: this.destination,
        departureHour: departureHour('01:00 PM'),
        stopType: 'Non-stop',
        isNonStop: true,
        isMorning: isMorning('01:00 PM'),
        isLate: isLate('01:00 PM'),
        duration: '3h 30m'
      },
      {
        id: 'FL789',
        flightNumber: 'FL789',
        airline: 'Air INDIA',
        departureTime: '06:00 PM',
        arrivalTime: '09:30 PM',
        price: '5620',
        source: this.source,
        destination: this.destination,
        departureHour: departureHour('06:00 PM'),
        stopType: '1 Stop',
        isNonStop: false,
        isMorning: isMorning('06:00 PM'),
        isLate: isLate('06:00 PM'),
        duration: '3h 30m'
      },
    ];
  }
}