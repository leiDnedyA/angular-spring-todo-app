import { Component, Input } from '@angular/core';
import { TodoItemComponent } from '../todo-item/todo-item.component';
import TodoItem from '../types/todoItem';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [TodoItemComponent],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent {
  todoItems = [{ id: '1', name: 'Take out trash' }, { id: '2', name: 'Do laundry' }];
  handleEdit(event: TodoItem) {
    console.log(event);
  }
}
