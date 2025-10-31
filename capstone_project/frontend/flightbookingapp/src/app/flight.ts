export interface Flight {
id: string;
  source: string;
  destination: string;
  airline: string;
  flightNumber: string;
  departureTime: string;
  arrivalTime: string;
  price: string;
  isNonStop: boolean;
  isMorning: boolean;
  isLate: boolean;
  departureHour: number;
  stopType: string;
  duration: string; 

}
