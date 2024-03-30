package com.example.tododemo.controllers;

import com.example.tododemo.entity.Todo;
import com.example.tododemo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService theTodoService) {
        this.todoService = theTodoService;
    }

    @GetMapping("/list")
    public String todolist(Model theModel){

        List<Todo> todos = todoService.findAll();

        theModel.addAttribute("todos", todos);

        return "tasks/task-list";
    }
    @GetMapping("/showFormForNewTask")
    public String showFormForNewTask(Model theModel){

        Todo task = new Todo();

        theModel.addAttribute("task", task);
        return "tasks/task-form";
    }

    @GetMapping("/showFormForUpdateTask")
    public String showFormForUpdateTask(Model theModel, @RequestParam("taskId") int id){

        Optional<Todo> task = todoService.findById(id);

        theModel.addAttribute("task", task);

        return "tasks/task-form";
    }

    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute("task") Todo task, BindingResult bindingResult){


        if (bindingResult.hasErrors()){
            return "tasks/task-form";
        }
        else {
            todoService.save(task);
            return "redirect:/tasks/list";
        }

    }
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskId") int id){
        todoService.deleteById(id);

        return "redirect:/tasks/list";
    }


}
