import { Component } from '@angular/core';
import { TaskList } from '../task-list/task-list';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ITask } from '../itask';
import { Task } from '../task/task';
@Component({
  selector: 'app-home',
  imports: [TaskList,CommonModule, FormsModule,Task],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
tasks: ITask[] = [];

  taskDescription: string = '';
  taskCategory: string = '';
  private taskIdCounter = 1;

  addTask() {
    if (!this.taskDescription.trim() || !this.taskCategory) {
      alert('Enter all fields before adding a task.');
      return;
    }
    if (this.taskDescription && this.taskCategory) {
      this.tasks.push({
        id: this.taskIdCounter++,
        description: this.taskDescription,
        category: this.taskCategory
      });
      this.taskDescription = '';
      this.taskCategory = '';
    }
  }

  removeTask(task: ITask) {
    this.tasks = this.tasks.filter(t => t.id !== task.id);
  }
}

