package org.springboot.monitoring.api.services;

import org.springboot.monitoring.api.dto.TodoDto;

import java.util.List;

public interface TodoService {

    List<TodoDto> findAll() throws Exception;

    TodoDto findById(Long id) throws Exception;

    TodoDto create(TodoDto todoDto) throws Exception;

    TodoDto edit(Long id, TodoDto todoDto) throws Exception;

    String delete(Long id) throws Exception;
}
