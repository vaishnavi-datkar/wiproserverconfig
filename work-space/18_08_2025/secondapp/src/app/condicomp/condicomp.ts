import { Component } from '@angular/core';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-condicomp',
  imports: [],
  templateUrl: './condicomp.html',
  styleUrl: './condicomp.css'
})
export class Condicomp {
flag = false;

//   toggle() {
//     this.flag = !this.flag;  
//
countries: string[] = ["India", "USA", "China", "Russia", "Japan"];
  dropdownList: string[] = [];   

  loadCountries() {
    this.dropdownList = this.countries; 
 }
}
