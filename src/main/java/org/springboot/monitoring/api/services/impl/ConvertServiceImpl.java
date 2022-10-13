package org.springboot.monitoring.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springboot.monitoring.api.dto.TodoDto;
import org.springboot.monitoring.api.entities.Todo;
import org.springboot.monitoring.api.services.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public Todo convertToEntity(TodoDto todoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(todoDto, Todo.class);
    }

    @Override
    public TodoDto convertToDto(Todo todo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(todo, TodoDto.class);
    }
}
