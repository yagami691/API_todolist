package com.example.todolist.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodolistRepository  extends JpaRepository<Todolist, Long>{
    List<Todolist> findAllByStatus(Status status);
    List<Todolist> findAllByTitre(String titre);
    Optional<Todolist> findTodolistById(Long id);


}
