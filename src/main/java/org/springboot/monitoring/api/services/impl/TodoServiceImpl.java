package org.springboot.monitoring.api.services.impl;

import org.springboot.monitoring.api.dto.TodoDto;
import org.springboot.monitoring.api.entities.Todo;
import org.springboot.monitoring.api.repositories.TodoRepository;
import org.springboot.monitoring.api.services.ConvertService;
import org.springboot.monitoring.api.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    ConvertService convertService;

    @Override
    public List<TodoDto> findAll() {
        return this.todoRepository.findAll().stream().map(convertService::convertToDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto findById(Long id) {
        return this.convertService.convertToDto(findOrFail(id));
    }

    @Override
    public TodoDto create(TodoDto todoDto) {
        return this.convertService.convertToDto(this.todoRepository.save(this.convertService.convertToEntity(todoDto)));
    }

    @Override
    public TodoDto edit(Long id, TodoDto todoDto) {
        findOrFail(id);
        Todo todo = this.convertService.convertToEntity(todoDto);
        todo.setId(id);
        return this.convertService.convertToDto(this.todoRepository.save(todo));
    }

    @Override
    public String delete(Long id) {
        Todo todo = findOrFail(id);
        this.todoRepository.deleteById(id);
        return "Todo eliminado.";
    }

    private Todo findOrFail(Long id) {
        return this.todoRepository.findById(id).orElse(null);
    }
}
