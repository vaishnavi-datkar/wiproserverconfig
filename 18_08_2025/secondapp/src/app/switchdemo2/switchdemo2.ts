import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-switchdemo2',
  imports: [FormsModule],
  templateUrl: './switchdemo2.html',
  styleUrl: './switchdemo2.css'
})
export class Switchdemo2 {
names: string[] = ['Jayanta', 'Jayaram', 'Apurba', 'Abir', 'Dipankar', 'Debabrata', 'Saurav', 'Sourav'];
  
  search: string = '';

  get filteredNames(): string[] {
    const searchTerm = this.search.toLowerCase();
     return this.names.filter(name => name.toLowerCase().startsWith(searchTerm));
  }
}