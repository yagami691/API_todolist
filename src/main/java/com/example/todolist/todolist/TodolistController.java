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

    @PutMapping(  "{newId}")
    public ResponseEntity<String> updateTodolists(
       @PathVariable ("newId") Long id, @RequestBody Todolist updateTodo){

        todolistService.updateTodolist(id, updateTodo.getTitle(), updateTodo.getDescription(),updateTodo.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body("Todolist updated successfully");
    }


    @DeleteMapping(path = "{todolistId}")
    public ResponseEntity<String> deleteTodolist(@PathVariable("todolistId") Long id){
        todolistService.deleteTodolist(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todolist deleted successfully");
    }

}
