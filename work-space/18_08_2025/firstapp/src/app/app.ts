import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Secondcomp } from './secondcomp/secondcomp';
import { Logincom } from './logincom/logincom';
import { Thirdcomp } from './thirdcomp/thirdcomp';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('firstapp');
}
