package com.example.todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class TodolistService {

    TodolistRepository todolistRepository;
    @Autowired
    public TodolistService(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    public List<Todolist> getTodolist(Status status){
        return todolistRepository.findAllByStatus(status);

    }
    public void addNewTodolist(Todolist newTodolist) {
        List<Todolist> existingTasks = todolistRepository.findAllByTitle(newTodolist.getTitle());

        boolean alreadyExists = existingTasks.stream()
                .anyMatch(task ->
                        task.getDescription().equalsIgnoreCase(newTodolist.getDescription()) &&
                                task.getStatus() == newTodolist.getStatus()
                );

        if (!alreadyExists) {
            todolistRepository.save(newTodolist);
        } else {
            throw new IllegalStateException("Tâche déjà existante !");
        }
    }


    public void updateTodolist(Long newId, String title, String description, Status status){
         Todolist newTodolistId = todolistRepository.findTodolistById(newId)
                 .orElseThrow(() -> new IllegalStateException(
                         "todolist with id "
                                 + newId + " does not exist"
                 ));
         if(title!=null && !title.trim().isEmpty() && !newTodolistId.getTitle().equals(title)){
               newTodolistId.setTitle(title);
           }
        if(description!=null && !description.trim().isEmpty() && !newTodolistId.getDescription().equals(description)){
            newTodolistId.setDescription(description);
        }
        if(status!=null && !Objects.equals(newTodolistId.getStatus(), status)){
            newTodolistId.setStatus(status);
        }

        todolistRepository.save(newTodolistId);

    }

    public void deleteTodolist(Long todolistId){

        boolean idExists = todolistRepository.existsById(todolistId);
        if(!idExists){
            throw new IllegalStateException("student with id "
                    + todolistId + " does not exist");
        }

        todolistRepository.deleteById(todolistId);
    }



}
