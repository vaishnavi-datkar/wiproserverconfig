import { Component } from '@angular/core';
import { DisplayList } from '../display-list/display-list';
import { CommonModule } from '@angular/common';
import { IFruit } from '../ifruit';

@Component({
  selector: 'app-home',
  imports: [CommonModule,DisplayList],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class Home {
fruits: IFruit[] = [
    {
      name: 'Apple',
      description: 'Apples are nutritious and good for health.',
      image: 'https://i.pinimg.com/1200x/11/b4/75/11b475a6bc40215c47f9fc606b095fc4.jpg'
    },
    {
      name: 'Banana',
      description: 'Bananas are rich in potassium and fiber.',
      image: 'https://i.pinimg.com/736x/b6/47/f0/b647f0612e26f84f103a061995a6b9c9.jpg'
    },
    {
      name: 'Orange',
      description: 'Orange fruits, sweet and juicy.',
      image: 'https://i.pinimg.com/1200x/75/a6/b7/75a6b72a756b4ece42aa848cb498679c.jpg'
    },
    {
      name: 'Dragon',
      description: 'Dragon fruits are rich in potassium and fiber.',
      image: 'https://i.pinimg.com/1200x/7d/de/2f/7dde2f8286bb027c9f87858d312e1be1.jpg'
    },
    {
      name: 'Pomegranate',
      description: 'Pomegranate fruits, sweet and juicy.',
      image: 'https://i.pinimg.com/736x/37/39/45/373945978bff3b5c9b0dfe27382f0120.jpg'
    },
    {
      name: 'Guava',
      description: 'Guava fruits, sweet and juicy.',
      image: 'https://i.pinimg.com/736x/aa/e5/85/aae58531e79bafce78adbabf687bbc75.jpg'
    }
  ];
removeFruit(name: string) {
    console.log('Removing fruit:', name);
    this.fruits = this.fruits.filter(fruit => fruit.name !== name);
}
}
