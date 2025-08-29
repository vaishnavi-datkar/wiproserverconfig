import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrls: ['./home.css']  

})
export class Home {
books = [
    { title: 'Book 1', desc: 'This is book 1 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 2', desc: 'This is book 2 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 3', desc: 'This is book 3 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 4', desc: 'This is book 4 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 5', desc: 'This is book 5 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 6', desc: 'This is book 6 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 7', desc: 'This is book 7 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 8', desc: 'This is book 8 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 9', desc: 'This is book 9 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 10', desc: 'This is book 10 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 11', desc: 'This is book 11 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 12', desc: 'This is book 12 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 13', desc: 'This is book 13 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 14', desc: 'This is book 14 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 15', desc: 'This is book 15 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 16', desc: 'This is book 16 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 17', desc: 'This is book 17 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 18', desc: 'This is book 18 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 19', desc: 'This is book 19 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' },
    { title: 'Book 20', desc: 'This is book 20 description.', image: 'assets/fe390c8f19b4fc2dcde43ec0eb709e56.jpg' }
  ];

}