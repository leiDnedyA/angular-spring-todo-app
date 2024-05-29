import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import TodoItem from '../types/todoItem';

@Component({
  selector: 'todo-item',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './todo-item.component.html',
  styleUrl: './todo-item.component.css'
})
export class TodoItemComponent {
  @Input() data = {id: '', name: ''};
  @Output() editEvent = new EventEmitter<TodoItem>();
  isEditable = false;
  toggleEditable() {
    this.isEditable = !this.isEditable;
  }
  handleEdit() {
    this.toggleEditable();
    this.editEvent.emit(this.data);
  }
}
