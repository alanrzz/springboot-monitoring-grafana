package org.springboot.monitoring.api.controllers.impl;


import org.springboot.monitoring.api.controllers.TodoController;
import org.springboot.monitoring.api.dto.TodoDto;
import org.springboot.monitoring.api.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoControllerImpl implements TodoController {

    @Autowired
    TodoService todoService;

    @Override
    @GetMapping
    public List<TodoDto> findAll() throws Exception {
        return this.todoService.findAll();
    }

    @Override
    @GetMapping(value = "{id}")
    public TodoDto findById(Long id) throws Exception {
        return this.todoService.findById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<TodoDto> create(TodoDto todoDto) throws Exception {
        return new ResponseEntity<>(this.todoService.create(todoDto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<TodoDto> edit(Long id, TodoDto todoDto) throws Exception {
        return new ResponseEntity<>(this.todoService.edit(id, todoDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> delete(Long id) throws Exception {
        return new ResponseEntity<>(this.todoService.delete(id), HttpStatus.OK);
    }
}
