
package dev.aydendiel.springtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    return db.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
    }
}
