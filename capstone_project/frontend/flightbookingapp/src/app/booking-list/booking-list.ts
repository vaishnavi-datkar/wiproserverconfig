import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, computed, inject, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from '../flight';
import { BookingDetails } from '../booking-details';
@Component({
  selector: 'app-booking-list',
  imports: [FormsModule,CommonModule],
  templateUrl: './booking-list.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./booking-list.css']
})
export class BookingList implements OnInit {
  currentView: 'results' | 'booking' | 'payment' = 'results';
  source: string = '';
  destination: string = '';
  departureDate: string = '';
  selectedFlight: Flight | null = null;
  errorMessage: string = '';
  showBookingSuccess: boolean = false;
  bookingId: string = '';
  
  // Payment details
  paymentMethod: 'card' | 'upi' = 'card';
  cardNumber: string = '';
  expiryDate: string = '';
  cvv: string = '';
  cardHolderName: string = '';
  upiId: string = '';
  paymentProcessing: boolean = false;
  paymentStatus: 'pending' | 'success' | 'failed' = 'pending';

  bookingDetails: BookingDetails = {
    passengerName: '',
    passengerEmail: '',
    passengerPhone: ''
  };

  // Enhanced flight data with more realistic entries
  allFlights: Flight[] = [
    { 
      id: 'FL001',
      source: 'Pune', 
      destination: 'Delhi', 
      airline: 'IndiGo', 
      flightNumber: '6E-2124', 
      departureTime: '06:00 AM', 
      arrivalTime: '08:30 AM', 
      price: '4500', 
      isNonStop: true, 
      isMorning: true, 
      isLate: false, 
      departureHour: 6, 
      stopType: 'Non-stop',
      duration: '2h 30m'
    },
    { 
      id: 'FL002',
      source: 'Pune', 
      destination: 'Delhi', 
      airline: 'Air India', 
      flightNumber: 'AI-631', 
      departureTime: '09:15 AM', 
      arrivalTime: '11:45 AM', 
      price: '5200', 
      isNonStop: true, 
      isMorning: true, 
      isLate: false, 
      departureHour: 9, 
      stopType: 'Non-stop',
      duration: '2h 30m'
    },
    { 
      id: 'FL003',
      source: 'Pune', 
      destination: 'Delhi', 
      airline: 'SpiceJet', 
      flightNumber: 'SG-8709', 
      departureTime: '02:30 PM', 
      arrivalTime: '06:45 PM', 
      price: '3800', 
      isNonStop: false, 
      isMorning: false, 
      isLate: false, 
      departureHour: 14, 
      stopType: '1 Stop',
      duration: '4h 15m'
    },
    { 
      id: 'FL004',
      source: 'Pune', 
      destination: 'Mumbai', 
      airline: 'IndiGo', 
      flightNumber: '6E-5124', 
      departureTime: '07:30 AM', 
      arrivalTime: '08:45 AM', 
      price: '2800', 
      isNonStop: true, 
      isMorning: true, 
      isLate: false, 
      departureHour: 7, 
      stopType: 'Non-stop',
      duration: '1h 15m'
    },
    { 
      id: 'FL005',
      source: 'Delhi', 
      destination: 'Mumbai', 
      airline: 'Vistara', 
      flightNumber: 'UK-955', 
      departureTime: '08:45 PM', 
      arrivalTime: '11:15 PM', 
      price: '6200', 
      isNonStop: true, 
      isMorning: false, 
      isLate: true, 
      departureHour: 20, 
      stopType: 'Non-stop',
      duration: '2h 30m'
    },
    { 
      id: 'FL006',
      source: 'Mumbai', 
      destination: 'Pune', 
      airline: 'Air India', 
      flightNumber: 'AI-642', 
      departureTime: '05:00 PM', 
      arrivalTime: '06:15 PM', 
      price: '3200', 
      isNonStop: true, 
      isMorning: false, 
      isLate: false, 
      departureHour: 17, 
      stopType: 'Non-stop',
      duration: '1h 15m'
    }
  ];

  flights: Flight[] = [];
  appliedFilters: { label: string, value: string }[] = [];
  
  // Filter states
  nonStopFilter = false;
  indigoFilter = false;
  morningFilter = false;
  eveningFilter = false;
  airIndiaFilter = false;

  constructor(private router: Router) {
    // Get navigation state data
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state) {
      this.source = navigation.extras.state['source'] || '';
      this.destination = navigation.extras.state['destination'] || '';
      this.departureDate = navigation.extras.state['departureDate'] || '';
      
      // If we have search parameters, filter flights immediately
      if (this.source && this.destination) {
        this.updateFlights();
      }
    }
  }

  ngOnInit(): void {
    this.flights = this.allFlights;
    // If we don't have search data from navigation, the template will show the fallback
  }

  goToSearch(): void {
    this.router.navigate(['/flightsearch']);
  }

  getMinPrice(filterType: string): number {
    let filtered: Flight[] = [];
    
    switch(filterType) {
      case 'nonStop':
        filtered = this.allFlights.filter(f => f.isNonStop);
        break;
      case 'IndiGo':
        filtered = this.allFlights.filter(f => f.airline === 'IndiGo');
        break;
      case 'morning':
        filtered = this.allFlights.filter(f => f.isMorning);
        break;
      case 'evening':
        filtered = this.allFlights.filter(f => f.departureHour >= 17);
        break;
      case 'airIndia':
        filtered = this.allFlights.filter(f => f.airline === 'Air India');
        break;
    }
    
    return filtered.length > 0 ? Math.min(...filtered.map(f => Number(f.price))) : 0;
  }

  toggleNonStopFilter(): void { 
    this.nonStopFilter = !this.nonStopFilter; 
    this.updateFlights(); 
    this.updateAppliedFilters(); 
  }
  
  toggleIndigoFilter(): void { 
    this.indigoFilter = !this.indigoFilter; 
    this.updateFlights(); 
    this.updateAppliedFilters(); 
  }
  
  toggleMorningFilter(): void { 
    this.morningFilter = !this.morningFilter; 
    this.updateFlights(); 
    this.updateAppliedFilters(); 
  }

  toggleEveningFilter(): void { 
    this.eveningFilter = !this.eveningFilter; 
    this.updateFlights(); 
    this.updateAppliedFilters(); 
  }

  toggleAirIndiaFilter(): void { 
    this.airIndiaFilter = !this.airIndiaFilter; 
    this.updateFlights(); 
    this.updateAppliedFilters(); 
  }

  removeAppliedFilter(filterValue: string): void {
    switch(filterValue) {
      case 'nonStop':
        this.nonStopFilter = false;
        break;
      case 'IndiGo':
        this.indigoFilter = false;
        break;
      case 'morning':
        this.morningFilter = false;
        break;
      case 'evening':
        this.eveningFilter = false;
        break;
      case 'airIndia':
        this.airIndiaFilter = false;
        break;
    }
    this.updateFlights(); 
    this.updateAppliedFilters();
  }

  clearAllFilters(): void { 
    this.nonStopFilter = false;
    this.indigoFilter = false; 
    this.morningFilter = false;
    this.eveningFilter = false;
    this.airIndiaFilter = false;
    this.updateFlights(); 
    this.updateAppliedFilters(); 
  }

  updateFlights(): void {
    let result = this.allFlights.filter(flight =>
      flight.source.toLowerCase() === this.source.toLowerCase() &&
      flight.destination.toLowerCase() === this.destination.toLowerCase()
    );
    
    if (this.nonStopFilter) result = result.filter(f => f.isNonStop);
    if (this.indigoFilter) result = result.filter(f => f.airline === 'IndiGo');
    if (this.morningFilter) result = result.filter(f => f.isMorning);
    if (this.eveningFilter) result = result.filter(f => f.departureHour >= 17);
    if (this.airIndiaFilter) result = result.filter(f => f.airline === 'Air India');
    
    this.flights = result;
  }

  updateAppliedFilters(): void {
    this.appliedFilters = [];
    if (this.nonStopFilter) this.appliedFilters.push({ label: 'Non Stop', value: 'nonStop' });
    if (this.indigoFilter) this.appliedFilters.push({ label: 'IndiGo', value: 'IndiGo' });
    if (this.morningFilter) this.appliedFilters.push({ label: 'Morning Departures', value: 'morning' });
    if (this.eveningFilter) this.appliedFilters.push({ label: 'Evening Departures', value: 'evening' });
    if (this.airIndiaFilter) this.appliedFilters.push({ label: 'Air India', value: 'airIndia' });
  }

  selectFlight(flight: Flight): void { 
    this.selectedFlight = flight; 
    this.currentView = 'booking'; 
  }

  proceedToPayment(): void {
    if (!this.bookingDetails.passengerName || !this.bookingDetails.passengerEmail || !this.bookingDetails.passengerPhone) {
      this.errorMessage = 'Please fill in all passenger details.';
      return;
    }

    // Basic email validation
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(this.bookingDetails.passengerEmail)) {
      this.errorMessage = 'Please enter a valid email address.';
      return;
    }

    // Basic phone validation (10 digits)
    const phonePattern = /^\d{10}$/;
    if (!phonePattern.test(this.bookingDetails.passengerPhone)) {
      this.errorMessage = 'Please enter a valid 10-digit phone number.';
      return;
    }

    this.errorMessage = '';
    this.generateBookingId();
    this.currentView = 'payment';
  }

  generateBookingId(): void {
    const timestamp = Date.now();
    const random = Math.floor(Math.random() * 1000);
    this.bookingId = `BK${timestamp}${random}`.substring(0, 12);
  }

  validatePaymentDetails(): boolean {
    if (this.paymentMethod === 'card') {
      // Card number validation (16 digits)
      if (!/^\d{16}$/.test(this.cardNumber.replace(/\s/g, ''))) {
        this.errorMessage = 'Card number must be 16 digits.';
        return false;
      }

      // Expiry date validation (MM/YY format and future date)
      const expiryPattern = /^(0[1-9]|1[0-2])\/\d{2}$/;
      if (!expiryPattern.test(this.expiryDate)) {
        this.errorMessage = 'Please enter expiry date in MM/YY format.';
        return false;
      }

      const [month, year] = this.expiryDate.split('/');
      const expiryDate = new Date(2000 + parseInt(year), parseInt(month) - 1);
      const today = new Date();
      
      if (expiryDate <= today) {
        this.errorMessage = 'Expiry date should be later than today.';
        return false;
      }

      // CVV validation (3 digits)
      if (!/^\d{3}$/.test(this.cvv)) {
        this.errorMessage = 'CVV must be 3 digits.';
        return false;
      }

      if (!this.cardHolderName.trim()) {
        this.errorMessage = 'Please enter card holder name.';
        return false;
      }
    } else if (this.paymentMethod === 'upi') {
      // Basic UPI ID validation
      const upiPattern = /^[a-zA-Z0-9.\-_]{2,256}@[a-zA-Z]{2,64}$/;
      if (!upiPattern.test(this.upiId)) {
        this.errorMessage = 'Please enter a valid UPI ID.';
        return false;
      }
    }

    return true;
  }

  processPayment(): void {
    if (!this.validatePaymentDetails()) {
      return;
    }

    this.errorMessage = '';
    this.paymentProcessing = true;

    // Simulate payment processing
    setTimeout(() => {
      // Simulate random success/failure (80% success rate)
      const isSuccess = Math.random() > 0.2;
      
      this.paymentProcessing = false;
      this.paymentStatus = isSuccess ? 'success' : 'failed';
      
      if (isSuccess) {
        this.showBookingSuccess = true;
      }
    }, 3000);
  }

  formatCardNumber(value: string): void {
    // Remove all non-digit characters
    const numericValue = value.replace(/\D/g, '');
    
    // Add spaces every 4 digits
    const formattedValue = numericValue.replace(/(\d{4})(?=\d)/g, '$1 ');
    
    this.cardNumber = formattedValue;
  }

  formatExpiryDate(value: string): void {
    // Remove all non-digit characters
    const numericValue = value.replace(/\D/g, '');
    
    // Add slash after 2 digits
    if (numericValue.length >= 2) {
      this.expiryDate = numericValue.substring(0, 2) + '/' + numericValue.substring(2, 4);
    } else {
      this.expiryDate = numericValue;
    }
  }

  onCardNumberInput(event: Event): void {
    const target = event.target as HTMLInputElement;
    this.formatCardNumber(target.value);
  }

  onExpiryDateInput(event: Event): void {
    const target = event.target as HTMLInputElement;
    this.formatExpiryDate(target.value);
  }

  downloadTicket(): void {
    // Create a simple text-based ticket for now
    const ticketContent = this.generateTicketContent();
    
    // Create and download as text file (you can replace this with PDF generation)
    const blob = new Blob([ticketContent], { type: 'text/plain' });
    const url = window.URL.createObjectURL(blob);
    const link = document.createElement('a');
    link.href = url;
    link.download = `flight-ticket-${this.bookingId}.txt`;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    window.URL.revokeObjectURL(url);
  }

   private generateTicketContent(): string {
    return `
==============================================================
                        FLIGHT E-TICKET                       
==============================================================

BOOKING INFORMATION
--------------------------------------------------------------
Booking ID:        ${this.bookingId}
Booking Date:      ${new Date().toLocaleDateString()}
Status:            CONFIRMED

FLIGHT DETAILS
--------------------------------------------------------------
Flight Number:     ${this.selectedFlight?.flightNumber || 'N/A'}
Airline:           ${this.selectedFlight?.airline || 'N/A'}
Route:             ${this.selectedFlight?.source} → ${this.selectedFlight?.destination}
Travel Date:       ${this.departureDate}
Departure Time:    ${this.selectedFlight?.departureTime || 'N/A'}
Arrival Time:      ${this.selectedFlight?.arrivalTime || 'N/A'}
Flight Duration:   ${this.selectedFlight?.duration || 'N/A'}
Flight Type:       ${this.selectedFlight?.stopType || 'N/A'}

PASSENGER DETAILS
--------------------------------------------------------------
Full Name:         ${this.bookingDetails.passengerName}
Email Address:     ${this.bookingDetails.passengerEmail}
Phone Number:      ${this.bookingDetails.passengerPhone}

PAYMENT SUMMARY
--------------------------------------------------------------
Base Fare:         ₹${this.getFlightPrice()}
Taxes & Fees:      ₹${this.getTaxesAndFees()}
--------------------------------------------------------------
TOTAL AMOUNT:      ₹${this.getTotalAmount()}
Payment Method:    ${this.paymentMethod.toUpperCase()}
Payment Status:    SUCCESSFUL

IMPORTANT TRAVEL INFORMATION
--------------------------------------------------------------
• Report at airport 2 hours before domestic departure
• Carry valid government-issued photo identification
• Check baggage allowance limits with airline
• Web check-in available 24 hours before departure
• This is your electronic ticket - print not mandatory
• Keep this ticket for your records

CONTACT INFORMATION
--------------------------------------------------------------
For support and queries:
Email: support@flightbooking.com
Phone: 1800-123-4567
Website: www.flightbooking.com

==============================================================
Thank you for choosing our flight booking service!
Ticket generated on: ${new Date().toLocaleString()}
==============================================================
    `.trim();
  }

  startNewBooking(): void {
    // Reset all form data
    this.source = '';
    this.destination = '';
    this.departureDate = '';
    this.selectedFlight = null;
    this.bookingDetails = {
      passengerName: '',
      passengerEmail: '',
      passengerPhone: ''
    };
    this.cardNumber = '';
    this.expiryDate = '';
    this.cvv = '';
    this.cardHolderName = '';
    this.upiId = '';
    this.paymentStatus = 'pending';
    this.showBookingSuccess = false;
    this.errorMessage = '';
    this.clearAllFilters();
    this.router.navigate(['/flightsearch']);
  }

  returnToSearch(): void { 
    this.router.navigate(['/flightsearch']);
  }

  returnToBooking(): void {
    this.currentView = 'booking';
    this.paymentStatus = 'pending';
    this.errorMessage = '';
  }

  returnToResults(): void {
    this.currentView = 'results';
  }

  // Helper methods for template calculations
  getFlightPrice(): number {
    return this.selectedFlight ? Number(this.selectedFlight.price) : 0;
  }

  getTaxesAndFees(): number {
    return Math.round(this.getFlightPrice() * 0.12);
  }

  getTotalAmount(): number {
    return this.getFlightPrice() + this.getTaxesAndFees();
  }
}