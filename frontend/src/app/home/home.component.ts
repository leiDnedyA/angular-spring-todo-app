import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { TodoItemComponent } from '../todo-item/todo-item.component';
import { TodoListComponent } from '../todo-list/todo-list.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, TodoItemComponent, TodoListComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  todoItems = [{ id: 1, name: 'Take out trash' }, { id: 2, name: 'Do laundry' }];
  handleUpdate() {};
}
