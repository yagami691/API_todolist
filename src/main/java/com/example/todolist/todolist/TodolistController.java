package com.example.todolist.todolist;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/todolist")
public class TodolistController {


    private final TodolistService todolistService;

    public TodolistController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping("/filter")
    public List<Todolist> filterTodolists(@RequestParam Status status) {
        return todolistService.getTodolist(status);
    }

    @PostMapping
    public ResponseEntity<String> addTodolists(@RequestBody Todolist addTodo){
           todolistService.addNewTodolist(addTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todolist added successfully");
    }
    @PutMapping(path = "{newId}")
    public void updateTodolists(
       @PathVariable ("newId") Long id,
       @RequestParam (required = false) String title,
       @RequestParam (required = false) String description,
       @RequestParam (required = false) Status status){
        todolistService.updateTodolist(id, title, description,status);
    }


    @DeleteMapping(path = "{todolistId}")
    public void deleteTodolist(@PathVariable("todolistId") Long id){
        todolistService.deleteTodolist(id);
    }

}
