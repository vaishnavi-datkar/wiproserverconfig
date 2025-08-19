import { Component, EventEmitter, Input,Output } from '@angular/core';
import { ITask } from '../itask';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-list',
  imports: [CommonModule],
  templateUrl: './task-list.html',
  styleUrl: './task-list.css'
})
export class TaskList {
@Input() tasks: ITask[] = [];
  @Output() removeTaskEvent = new EventEmitter<ITask>();

  removeTask(task: ITask) {
    this.removeTaskEvent.emit(task);
  }
}
