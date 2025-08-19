import { NgStyle } from '@angular/common';
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [NgStyle],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('thirdapp');
   flag1:boolean =false;
  flag2:boolean = true;
  color1:string='blue';
  fontSize1:string='20px';
   getNgClass() {
    return {
      app1: this.flag1,
      app2: this.flag2
    };
  }
}
