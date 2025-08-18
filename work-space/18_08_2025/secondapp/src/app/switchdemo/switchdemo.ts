import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-switchdemo',
  imports: [FormsModule],
  templateUrl: './switchdemo.html',
  styleUrl: './switchdemo.css'
})
export class Switchdemo {
color: string='green';
changeColor(color: string) {
    this.color = color;
}
}