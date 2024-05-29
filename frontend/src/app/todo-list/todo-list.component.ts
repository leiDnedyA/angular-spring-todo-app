import { Component, Inject, Input, OnInit } from '@angular/core';
import { TodoItemComponent } from '../todo-item/todo-item.component';
import TodoItem from '../types/todoItem';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [TodoItemComponent],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent implements OnInit {
  constructor(@Inject(HttpClient) public http: HttpClient) {}
  todoItems = [{ id: '1', name: 'Take out trash' }, { id: '2', name: 'Do laundry' }];
  handleEdit(event: TodoItem) {
    console.log(event);
  }
  public getTodoItems() {
    console.log(this.http)
    this.http.get<TodoItem[]>('/todo-items/').subscribe(todoItems => {
      this.todoItems = todoItems;
    })
  }
  ngOnInit() {
    this.getTodoItems();
  }
}
