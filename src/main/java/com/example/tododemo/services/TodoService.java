package com.example.tododemo.services;

import com.example.tododemo.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> findAll();

    Optional<Todo> findById(int id);

    void save(Todo todo);

    void deleteById(int id);

}
