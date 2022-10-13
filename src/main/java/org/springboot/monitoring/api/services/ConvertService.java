package org.springboot.monitoring.api.services;

import org.springboot.monitoring.api.dto.TodoDto;
import org.springboot.monitoring.api.entities.Todo;

public interface ConvertService {

    Todo convertToEntity(TodoDto todoDto);

    TodoDto convertToDto(Todo todo);
}
