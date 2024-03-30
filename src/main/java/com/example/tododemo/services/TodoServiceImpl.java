package com.example.tododemo.services;

import com.example.tododemo.DAO.TodoRepository;
import com.example.tododemo.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findById(int id) {
        return todoRepository.findById(id);
    }

    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }
}
