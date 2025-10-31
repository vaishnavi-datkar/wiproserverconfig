import { Routes } from '@angular/router';
import { BookingList } from './booking-list/booking-list';
import { Flightsearch } from './flightsearch/flightsearch';


export const routes: Routes = [{ path: '', redirectTo: '/flightsearch', pathMatch: 'full' },
  { path: 'flightsearch', component: Flightsearch },
  { path: 'booking-list', component: BookingList },
];
