import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ITask } from '../itask';
@Component({
  selector: 'app-task',
  imports: [CommonModule],
  templateUrl: './task.html',
  styleUrl: './task.css'
})
export class Task {
 @Input() task!: ITask;
  @Output() btnClick = new EventEmitter<ITask>();

  removeTask() {
    this.btnClick.emit(this.task);
  }
}
