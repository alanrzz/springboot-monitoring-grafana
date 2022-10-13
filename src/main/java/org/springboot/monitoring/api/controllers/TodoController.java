package org.springboot.monitoring.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springboot.monitoring.api.dto.TodoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Todo operations", tags = "Todo")
public interface TodoController {

    @ApiOperation(value = "Obtener todas las tareas.")
    List<TodoDto> findAll() throws Exception;

    @ApiOperation(value = "Buscar una tarea.", response = TodoDto.class)
    TodoDto findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation(value = "Registrar una nueva tarea.")
    ResponseEntity<TodoDto> create(@Valid @RequestBody TodoDto todoDto) throws Exception;

    @ApiOperation(value = "Editar una tarea.")
    ResponseEntity<TodoDto> edit(@PathVariable("id") Long id, @Valid @RequestBody TodoDto todoDto) throws Exception;

    @ApiOperation(value = "Eliminar una tarea.")
    ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception;
}