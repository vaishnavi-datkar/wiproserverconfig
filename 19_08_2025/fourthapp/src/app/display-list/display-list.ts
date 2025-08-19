import { CommonModule } from '@angular/common';
import { Component, Input, Output,EventEmitter } from '@angular/core';import { FormsModule } from '@angular/forms';
import { IFruit } from '../ifruit';
@Component({
  selector: 'app-display-list',
  imports: [CommonModule],
templateUrl: './display-list.html',
styleUrls: ['./display-list.css']

})
export class DisplayList {
// @Input() name!: string;
// @Input() description!: string;
// @Input() image!: string;
 @Input() fruit!: IFruit;
@Output() btnClick = new EventEmitter<IFruit>();

  // Emit the fruit to the parent when remove is clicked
  removeFruit() {
    console.log('Clicked Remove for:', this.fruit.name);
    this.btnClick.emit(this.fruit);
}
}