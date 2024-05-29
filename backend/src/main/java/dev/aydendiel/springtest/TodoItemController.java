
package dev.aydendiel.springtest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TodoItemController {

//    private Map<String, TodoItem> db = List.of(new TodoItem("1", "first item"), new TodoItem("2", "second item"));
    private Map<String, TodoItem> db = new HashMap<>() {{
        put("1", new TodoItem("1", "Take out trash"));
}};

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/todo-items")
    public Collection<TodoItem> get() {
        return db.values();
    }

    @GetMapping("/todo-items/{id}")
    public List<TodoItem> get(@PathVariable String id) {
        if (db.containsKey(id)) {
            return List.of(db.get(id));
        }
        return List.of();
    }

    @PostMapping("/todo-items/")
    public List<TodoItem> post(@RequestBody TodoItem todoItem) {
        String newKey = String.valueOf(db.size() + 1);
        db.put(newKey, todoItem);
        return List.of(db.get(newKey));
    }

    @PutMapping("/todo-items/{id}")
    public List<TodoItem> put(@RequestBody TodoItem todoItem, @PathVariable String id) {
        if (db.containsKey(id)) {
            TodoItem currItem = db.get(id);
            currItem.setName(todoItem.getName());
        } else {
            db.put(id, todoItem);
        }
        return List.of(db.get(id));
    }

    @DeleteMapping("/todo-items/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (db.containsKey(id)) {
            db.remove(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(404));
    }
}
